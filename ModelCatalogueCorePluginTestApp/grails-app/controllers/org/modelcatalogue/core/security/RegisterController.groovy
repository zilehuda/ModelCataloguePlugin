package org.modelcatalogue.core.security

import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.ui.RegisterCommand
import grails.plugin.springsecurity.ui.RegistrationCode
import org.modelcatalogue.core.RegisterService
import org.modelcatalogue.core.TransactionalEmailService
import org.springframework.security.core.context.SecurityContextHolder

class RegisterController extends grails.plugin.springsecurity.ui.RegisterController {

    UserService userService

    TransactionalEmailService transactionalEmailService

    RegisterService registerService

    def register(RegisterCommand command) {

        if (!grailsApplication.config.mc.allow.signup) {
            flash.error = "Registration is not enabled for this application"
            return
        }
        params.remove 'format'

        if (command.hasErrors()) {
            render view: 'index', model: [command: command]
            return
        }

        def adminEmail = System.getenv(UserService.ENV_ADMIN_EMAIL)
        def supervisorEmail = System.getenv(UserService.ENV_SUPERVISOR_EMAIL)
        boolean shouldUserBeDisabled =  (adminEmail && command.email != adminEmail) && (supervisorEmail && command.email != supervisorEmail)
        boolean enabled = !shouldUserBeDisabled
        if ( shouldUserBeDisabled ) {
            // notify admin
            transactionalEmailService.sendEmail(adminEmail,
                    conf.ui.register.emailFrom,
                    "Metadata Registry - new user",
                    "New user registered to your Metadata Registry. Please enable that account in user administration.")
        }

        RegistrationCode registrationCode = registerService.register(command.username, command.password, command.email, enabled)
        if (registrationCode == null || registrationCode.hasErrors()) {
            // null means problem creating the user
            flash.error = message(code: 'spring.security.ui.register.miscError')
            flash.chainedParams = params
            redirect action: 'index'
            return
        }

        String url = generateLink('verifyRegistration', [t: registrationCode.token])

        def conf = SpringSecurityUtils.securityConfig
        def body = conf.ui.register.emailBody
        if (body.contains('$')) {
            body = evaluate(body, [user: command, url: url])
        }

        transactionalEmailService.sendEmail(command.email,
                conf.ui.register.emailFrom as String,
                conf.ui.register.emailSubject as String,
                body.toString())


        render view: 'index', model: [emailSent: true]
    }

    def forgotPassword() {

        if (!request.post) {
            // show the form
            return
        }

        String username = params.username
        if (!username) {
            flash.error = message(code: 'spring.security.ui.forgotPassword.username.missing')
            redirect action: 'forgotPassword'
            return
        }

        User user = User.findByUsernameOrEmail(username, username)
        if (!user) {
            flash.error = message(code: 'spring.security.ui.forgotPassword.user.notFound')
            redirect action: 'forgotPassword'
            return
        }

        if (!user.email) {
            flash.error = message(code: 'spring.security.ui.forgotPassword.user.noEmail')
            redirect action: 'forgotPassword'
            return
        }

        def registrationCode = new RegistrationCode(username: user.username)
        registrationCode.save(flush: true)

        String url = generateLink('resetPassword', [t: registrationCode.token])

        def conf = SpringSecurityUtils.securityConfig
        def body = conf.ui.forgotPassword.emailBody
        if (body.contains('$')) {
            body = evaluate(body, [user: user, url: url])
        }
        mailService.sendMail {
            to user.email
            from conf.ui.forgotPassword.emailFrom
            subject conf.ui.forgotPassword.emailSubject
            html body.toString()
        }

        [emailSent: true]
    }

    // TODO: after registration the user
    def verifyRegistration() {

        def conf = SpringSecurityUtils.securityConfig
        String defaultTargetUrl = conf.successHandler.defaultTargetUrl

        String token = params.t

        def registrationCode = token ? RegistrationCode.findByToken(token) : null
        if (!registrationCode) {
            flash.error = message(code: 'spring.security.ui.register.badCode')
            redirect uri: defaultTargetUrl
            return
        }

        def user = null
        // TODO to ui service
        RegistrationCode.withTransaction { status ->
            user = lookupUserClass().findWhere(username: registrationCode.username)
            if (!user) {
                return
            }
            user.save(flush: true)
            def UserRole = lookupUserRoleClass()
            def Role = lookupRoleClass()
            for (roleName in conf.ui.register.defaultRoleNames) {
                UserRole.create user, Role.findByAuthority(roleName)
            }

            if (System.getenv(UserService.ENV_ADMIN_EMAIL) && user.email == System.getenv(UserService.ENV_ADMIN_EMAIL)) {
                userService.redefineRoles(user, UserService.ACCESS_LEVEL_ADMIN)
            }
            if (System.getenv(UserService.ENV_SUPERVISOR_EMAIL) && user.email == System.getenv(UserService.ENV_SUPERVISOR_EMAIL)) {
                userService.redefineRoles(user, UserService.ACCESS_LEVEL_SUPERVISOR)
            }

            registrationCode.delete()
        }

        if (!user) {
            flash.error = message(code: 'spring.security.ui.register.badCode')
            redirect uri: defaultTargetUrl
            return
        }

        if (user.accountLocked) {
            flash.message = message(code: 'spring.security.ui.register.complete.but.locked')
        } else {
            flash.message = message(code: 'spring.security.ui.register.complete')
        }

        // make sure no user is logged in
        SecurityContextHolder.clearContext()
        redirect uri: defaultTargetUrl
    }

    protected String generateLink(String action, linkParams) {
        createLink(base: grailsApplication.config.grails.serverURL,
                   controller: 'register', action: action,
                   params: linkParams)
    }
}
