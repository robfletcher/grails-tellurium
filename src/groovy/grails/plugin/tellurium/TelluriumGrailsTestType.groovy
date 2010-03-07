package grails.plugin.tellurium

import org.codehaus.groovy.grails.test.junit3.JUnit3GrailsTestType
import org.tellurium.connector.SeleniumConnector
import org.tellurium.framework.TelluriumFramework
import org.tellurium.bootstrap.TelluriumSupport
import org.codehaus.groovy.grails.test.junit3.JUnit3GrailsTestTypeMode

class TelluriumGrailsTestType extends JUnit3GrailsTestType {

	static SeleniumConnector connector
	private TelluriumFramework aost

	TelluriumGrailsTestType(String name, String sourceDirectory) {
		super(name, sourceDirectory)
	}

	TelluriumGrailsTestType(String name, String sourceDirectory, JUnit3GrailsTestTypeMode mode) {
		super(name, sourceDirectory, mode)
	}

	protected int doPrepare() {
		def count = super.doPrepare()
		if (count > 0) {
			aost = TelluriumSupport.addSupport()
			aost.start(null)
			connector = aost.connector
		}
		return count
	}

	def void cleanup() {
		aost?.stop()
		super.cleanup()
	}
}
