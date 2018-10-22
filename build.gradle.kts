import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm") version "1.2.71"
    // need to use Gretty here because of https://github.com/johndevs/gradle-vaadin-plugin/issues/317
    id("org.gretty") version "2.2.0"
    war
}

defaultTasks("clean", "build")

repositories {
    jcenter()
    maven { setUrl("https://dl.bintray.com/mvysny/github") }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

gretty {
    contextPath = "/"
    servletContainer = "tomcat9"
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        // to see the exceptions of failed tests in Travis-CI console.
        exceptionFormat = TestExceptionFormat.FULL
    }
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("io.javalin:javalin:2.3.0")
    compile("org.slf4j:slf4j-simple:1.7.25")
}
