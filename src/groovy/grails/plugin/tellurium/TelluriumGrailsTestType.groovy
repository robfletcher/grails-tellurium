package grails.plugin.tellurium

import org.codehaus.groovy.grails.test.junit3.JUnit3GrailsTestType
import org.codehaus.groovy.grails.test.junit3.JUnit3GrailsTestTypeMode
import org.telluriumsource.component.connector.SeleniumConnector
import org.telluriumsource.framework.TelluriumFramework
import org.telluriumsource.framework.bootstrap.TelluriumSupport

class TelluriumGrailsTestType extends JUnit3GrailsTestType {

	static SeleniumConnector connector
	private TelluriumFramework tellurium

	TelluriumGrailsTestType(String name, String sourceDirectory) {
		super(name, sourceDirectory)
	}

	TelluriumGrailsTestType(String name, String sourceDirectory, JUnit3GrailsTestTypeMode mode) {
		super(name, sourceDirectory, mode)
	}

	protected int doPrepare() {
		println "doPrepare"
		def count = super.doPrepare()
		if (count > 0) {
			tellurium = TelluriumSupport.addSupport()
			tellurium.start()
			connector = tellurium.connector
			println "connector = $connector"
			connector.connectSeleniumServer()
			tellurium.useCache true
		}
		return count
	}

	def void cleanup() {
		connector.disconnectSeleniumServer()
		tellurium?.stop()
		super.cleanup()
	}
}
