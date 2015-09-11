package org.modelcatalogue.core.b

import geb.navigator.Navigator
import org.modelcatalogue.core.AbstractModelCatalogueGebSpec
import org.modelcatalogue.core.pages.GlobalChangesPage
import org.modelcatalogue.core.pages.DataType2Page
import spock.lang.Stepwise

@Stepwise
class ChangesSpec extends AbstractModelCatalogueGebSpec {

    def "go to login"() {
        go "#/"
        loginAdmin()

        go "#/catalogue/dataType/all"
        at DataType2Page

        waitFor(120) {
            viewTitle.displayed
        }
        waitFor {
            viewTitle.text().trim().endsWith 'Data Type List'
        }

        fastAction 'New Data Type'

        noStale({$('input[id=name]')}) {
            it.value("Data Type ${System.nanoTime()}")
        }

        noStale({$('input[id=dataModel]')}) {
            it.value("Data Model ${System.nanoTime()}")
        }


        actionButton('modal-save-element', 'modal').click()

        fastAction 'Switch to Finalized'

        when:
        go "#/catalogue/change/all"

        then:
        at GlobalChangesPage
        waitFor(120) {
            viewTitle.displayed
        }
        waitFor {
            viewTitle.text().trim() == 'Change List'
        }
    }

    def "check the unit shows up with own detail page"(){
        when:
        waitFor {
            infTableCell(1, 4).find('a span.fa.fa-fw.fa-link').displayed
        }
        noStale({ infTableCell(1, 4).find('a span.fa.fa-fw.fa-link').parent('a') }, { Navigator link ->
            link.click()
        })
        then:
        waitFor {
            $("li[data-tab-name='changes']").displayed
        }

        $(".pp-table-property-element-value", 'data-value-for': 'Undone').displayed
        $(".pp-table-property-element-value", 'data-value-for': 'Undone').text() == 'false'

        when:
        noStale({ actionButton('undo-change') }) { Navigator button ->
            button.click()
        }

        then:
        waitFor {
            confirmDialog.displayed
        }

        when:
        confirmOk.click()

        then:
        waitFor {
            $(".pp-table-property-element-value", 'data-value-for': 'Undone').text() == 'true'
        }
    }

    def "users have activity feed"() {
        go "#/catalogue/user/all"

        expect:
        waitFor {
            viewTitle.text().trim() == 'User List'
        }
        waitFor {
            infTableCell(1, 2).find('a', text: 'admin').displayed
        }

        when:
        noStale({ infTableCell(1, 2).find('a', text: 'admin') }) {
            it.click()
        }

        then:
        waitFor {
            subviewTitle.displayed
        }
        waitFor {
            subviewTitle.text().trim() == 'admin FINALIZED'
        }
        waitFor {
            $("li[data-tab-name='activity']").displayed
        }
        waitFor {
            $("li[data-tab-name='history']").displayed
        }

        when:
        selectTab 'history'

        then: "the history tab contains treeview item which does not resize"
        waitFor {
            $('#history-tab .catalogue-element-treeview-list-container.no-resize')
        }
        waitFor {
            $('span.catalogue-element-treeview-name', text: "admin 1").displayed
        }
        waitFor {
            $('.glyphicon-folder-close').parent('a').displayed
        }

        when:
        noStale({$('.glyphicon-folder-close').parent('a')}) {
            it.click()
        }

        then:
        waitFor {
            $('span.catalogue-element-treeview-name', text: "admin (User) [1] created").displayed
        }
    }

    def "classifications have activity feed"() {
        when:
        go "#/catalogue/dataModel/all"

        then:
        waitFor {
            $('h3', title: 'XMLSchema').displayed
        }

        when:
        $('h3', title: 'XMLSchema').find('a').click()

        then:
        waitFor {
            menuItem('currentDataModel').text().contains('XMLSchema')
        }

        when:
        waitFor {
            menuItem('currentDataModel').displayed
        }
        menuItem('currentDataModel').click()

        then:
        waitFor {
            menuItem('feed', '').displayed
        }
        waitFor {
            menuItem('show-data-model', '').displayed
        }

        when:
        menuItem('show-data-model', '').click()

        then:
        waitFor {
            subviewTitle.displayed
        }
        waitFor {
            $("li[data-tab-name='activity']").displayed
        }
    }

}