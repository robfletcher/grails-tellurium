grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir	= "target/test-reports"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits( "global" )
    log "warn"
    repositories {
        grailsPlugins()
        grailsHome()
        mavenLocal()
        mavenCentral()
        mavenRepo "http://snapshots.repository.codehaus.org"
        mavenRepo "http://repository.codehaus.org"
        mavenRepo "http://download.java.net/maven/2/"
        mavenRepo "http://repository.jboss.com/maven2/"
		mavenRepo "http://maven.kungfuters.org/content/repositories/releases"
		mavenRepo "http://maven.kungfuters.org/content/repositories/snapshots"
		mavenRepo "http://maven.kungfuters.org/content/repositories/thirdparty"
    }
    dependencies {
        test("org.telluriumsource:tellurium-core:0.7.0") {
			excludes "gmaven-runtime-1.6", "groovy-all", "poi", "testng", "junit"
		}
    }

}
