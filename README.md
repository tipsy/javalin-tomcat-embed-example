# Javalin Tomcat Embed Test

Tests embedding of [Javalin](https://javalin.io/) into the Tomcat servlet container.
See https://github.com/tipsy/javalin/issues/402 for more details.

Run using `./gradlew clean appRun`. Then, running `curl localhost:8080/rest/` in your terminal yields "Hello!".

To do:

* Remove Jetty, since embedding a servlet container into another servlet container makes no sense.
