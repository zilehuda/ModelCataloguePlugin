package org.modelcatalogue.core

import org.modelcatalogue.core.security.Role
import org.modelcatalogue.core.security.User

/**
 * Default implementation meaning no security. The user is always logged in and has all the roles.
 */
class ModelCatalogueSecurityService implements SecurityService, LogoutListeners {

    static transactional = false

    @Override
    boolean isUserLoggedIn() {
        return true
    }

    @Override
    boolean hasRole(String role) {
        return true
    }

    @Override
    boolean hasRole(String role, DataModel dataModel) {
        return true
    }

    @Override
    String encodePassword(String password) {
        return password
    }

    @Override
    User getCurrentUser() {
        return null
    }

    @Override
    Map<String, Long> getUsersLastSeen() {
        return [:]
    }

    @Override
    boolean isSubscribed(CatalogueElement ce) {
        return true
    }

    @Override
    void addUserRoleModel(User user, Role role, DataModel model){}

    @Override
    void removeUserRoleModel(User user, Role role, DataModel model){}

    @Override
    void removeAllUserRoleModel(User user, DataModel model){}

    @Override
    void logout(String username) {}

    @Override
    boolean isSupervisor(){
        return true
    }

    void copyUserRoles(DataModel sourceModel, DataModel destinationModel){}
}
