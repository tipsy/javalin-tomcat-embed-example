# Javalin Tomcat Embed Test

Tests embedding of [Javalin](https://javalin.io/) into the Tomcat servlet container.
See https://github.com/tipsy/javalin/issues/402 for more details.

To use, first build a custom version of Javalin and make Maven place it into the local repo:

1. `git clone https://github.com/mvysny/javalin`
2. `cd javalin && mvn clean install`

Now, you can run this project using `./gradlew clean appRun`. Then, running `curl localhost:8080/rest/` in your terminal yields "Hello!".
