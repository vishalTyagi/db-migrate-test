grails.project.work.dir = 'target'
grails.project.source.level = 1.6
grails.project.dependency.resolver = "maven"
grails.project.dependency.resolution = {

	inherits 'global'
	log 'warn'

	repositories {
		grailsCentral()
        mavenCentral()
	}

	dependencies {}

	plugins {
		/*build(':release:2.0.3', ':rest-client-builder:1.0.2') {
			export = false
		}*/
	}
}
