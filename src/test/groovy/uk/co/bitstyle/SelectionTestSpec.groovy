package uk.co.bitstyle

import spock.lang.Ignore

/**
 *
 *
 * @author cspiking
 */
@Ignore
class SelectionTestSpec extends BaseGebSpec {

    def "Selection box is displayed on index page"() {
        when:
        go "/aurelia#/select-view"
        waitFor { $(".selectedOptionString").displayed }

        then:
        1 == 1

        when:
        waitFor { $("FORM").find("SELECT", name: "selectionBoxThing").displayed }
        $("FORM").find("SELECT", name: "selectionBoxThing").value("Fred Flintstone")

        then:
        $(".selectedOptionString", 0).text().trim() == "{\"valueOne\":\"Fred\",\"valueTwo\":\"Flintstone\"}"
    }

    def "Aurelia PhantomJS - Selection box is displayed on index page"() {
        when:
        go "/aurelia#/m-select-view"
        waitFor { $("FORM", role: "form").$("DIV.selectDropDownClass").$("INPUT.select-dropdown").displayed }

        then:
        1 == 1

        when:
        $("FORM", role: "form").$("DIV.selectDropDownClass").$("INPUT.select-dropdown").click()
        $("FORM", role: "form").$("DIV.selectDropDownClass").$("SPAN", text: "Fred Flintstone").click()

        then:
        $(".selectedOptionString", 0).text().trim() == "{\"valueOne\":\"Fred\",\"valueTwo\":\"Flintstone\"}"
    }

    // This does not work because of something stupid in the aurelia materialize bridge/firefox that means clicking on the
    // selection span element does not close the select box/cause the click event to be registered.
    @Ignore
    def "Aurelia Firefox - Selection box is displayed on index page"() {
        when:
        go "/aurelia#/m-select-view"
        waitFor { $("FORM", role: "form").$("DIV.selectDropDownClass").$("INPUT.select-dropdown").displayed }

        then:
        1 == 1

        when:
        $("FORM", role: "form").$("DIV.selectDropDownClass").$("INPUT.select-dropdown").click()
        waitFor { $("FORM", role: "form").$("DIV.selectDropDownClass").$("SPAN", text: "Fred Flintstone").displayed }
        $("FORM", role: "form").$("DIV.selectDropDownClass").$("SPAN", text: "Fred Flintstone").click()

        then:
        $(".selectedOptionString", 0).text().trim() == "{\"valueOne\":\"Fred\",\"valueTwo\":\"Flintstone\"}"
    }

    @Ignore
    def "Aurelia ChromeDriver - Selection box is displayed on index page"() {
        when:
        go "/aurelia#/m-select-view"
        waitFor { $("FORM", role: "form").$("DIV.selectDropDownClass").$("INPUT.select-dropdown").displayed }

        then:
        1 == 1

        when:
        $("FORM", role: "form").$("DIV.selectDropDownClass").$("INPUT.select-dropdown").click()
        $("FORM", role: "form").$("DIV.selectDropDownClass").$("SPAN", text: "Fred Flintstone").click()

        then:
        $(".selectedOptionString", 0).text().trim() == "{\"valueOne\":\"Fred\",\"valueTwo\":\"Flintstone\"}"
    }
}
