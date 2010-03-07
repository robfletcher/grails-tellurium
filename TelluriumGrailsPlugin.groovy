class TelluriumGrailsPlugin {

    def version = "1.0-SNAPSHOT"
    def grailsVersion = "1.2.1 > *"
    def dependsOn = [:]
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def author = "Rob Fletcher"
    def authorEmail = "rob@energizedwork.com"
    def title = "Tellurium Plugin"
    def description = '''\\
Integrates the Tellurium testing framework into Grails' functional test phase.
'''

    def documentation = "http://grails.org/plugin/tellurium"

    def doWithWebDescriptor = { xml ->
    }

    def doWithSpring = {
    }

    def doWithDynamicMethods = { ctx ->
    }

    def doWithApplicationContext = { applicationContext ->
    }

    def onChange = { event ->
    }

    def onConfigChange = { event ->
    }
}
