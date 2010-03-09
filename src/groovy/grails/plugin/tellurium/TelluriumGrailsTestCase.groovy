package grails.plugin.tellurium

import org.tellurium.connector.SeleniumConnector
import org.tellurium.test.groovy.BaseTelluriumGroovyTestCase

class TelluriumGrailsTestCase extends BaseTelluriumGroovyTestCase {

	SeleniumConnector getConnector() {
		return TelluriumGrailsTestType.connector
	}

}
