package grails.plugin.tellurium

import org.codehaus.groovy.grails.test.junit4.JUnit4GrailsTestType
import org.codehaus.groovy.grails.test.support.GrailsTestMode
import org.telluriumsource.component.connector.SeleniumConnector
import org.telluriumsource.framework.TelluriumFramework
import org.telluriumsource.framework.bootstrap.TelluriumSupport

class TelluriumGrailsTestType extends JUnit4GrailsTestType {

	static SeleniumConnector connector
	private TelluriumFramework tellurium

	TelluriumGrailsTestType(String name, String sourceDirectory) {
		super(name, sourceDirectory)
	}

	def TelluriumGrailsTestType(String name, String sourceDirectory, GrailsTestMode mode) {
		super(name, sourceDirectory, mode)
	}

	protected int doPrepare() {
		def count = super.doPrepare()
		println "Found $count Tellurium tests..."
		if (count > 0) {
			println "Starting Tellurium..."
			tellurium = TelluriumSupport.addSupport()
			tellurium.start(null)
			connector = tellurium.connector
			connector.connectSeleniumServer()
			println "connector = $connector..."
		}
		return count
	}

	def void cleanup() {
		connector?.disconnectSeleniumServer()
		tellurium?.stop()
		super.cleanup()
	}
}
