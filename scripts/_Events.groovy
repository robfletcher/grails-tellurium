loadTelluriumTestTypeClass = {->
	def doLoad = {-> classLoader.loadClass("grails.plugin.tellurium.TelluriumGrailsTestType") }
	try {
		doLoad()
	} catch (ClassNotFoundException e) {
		includeTargets << grailsScript("_GrailsCompile")
		compile()
		doLoad()
	}
}

eventAllTestsStart = {
	def telluriumTestTypeClass = loadTelluriumTestTypeClass()
	functionalTests << telluriumTestTypeClass.newInstance("tellurium", "tellurium")
}
