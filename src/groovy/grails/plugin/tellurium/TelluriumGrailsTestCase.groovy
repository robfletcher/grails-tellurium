package grails.plugin.tellurium

import org.telluriumsource.component.connector.SeleniumConnector
import org.telluriumsource.test.groovy.BaseTelluriumGroovyTestCase

class TelluriumGrailsTestCase extends BaseTelluriumGroovyTestCase {

	SeleniumConnector getConnector() {
		return TelluriumGrailsTestType.connector
	}

}
