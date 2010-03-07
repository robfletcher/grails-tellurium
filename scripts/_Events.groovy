eventAllTestsStart = {
	def testType = Thread.currentThread().contextClassLoader.loadClass("grails.plugin.tellurium.TelluriumGrailsTestType")
	functionalTests << testType.newInstance("tellurium", "tellurium")
}
