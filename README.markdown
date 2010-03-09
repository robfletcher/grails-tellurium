# Grails Tellurium Plugin

Tellurium is a browser-based testing framework based on Selenium. The Tellurium plugin for Grails integrates the Tellurium framework with Grails' functional testing phase.

## Writing Tellurium tests
Tellurium tests should be placed in `test/tellurium` and extend the `grails.plugin.tellurium.TelluriumGrailsTestCase` base class. UI modules can go anywhere in the classpath but would typically also be placed in `test/tellurium`. For the time being `TelluriumConfig.groovy` needs to go in the root of the project. This will be remedied in future so that it can go under `grails-app/conf` with other configuration files.

## Running Tellurium tests
Tellurium tests run in the `functional:tellurium` phase so they will run with:

 * `grails test-app`
 * `grails test-app functional:`
 * `grails test-app :tellurium`
 * `grails test-app functional:tellurium`

Individual test names can be used just as with regular Grails tests.