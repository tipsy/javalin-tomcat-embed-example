package org.test

import io.javalin.EmbeddedJavalin
import io.javalin.core.util.Util
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(urlPatterns = ["/rest/*"], name = "MyFooServlet", asyncSupported = false)
class MyFooServlet : HttpServlet() {
    val javalin = EmbeddedJavalin()
        .get("/rest") { ctx -> ctx.result("Hello!") }
        .createServlet()

    init {
        // to prevent Javalin from from displaying an helpful message (which is unhelpful in this case)
        Util.noServerHasBeenStarted = false
    }

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        javalin.service(req, resp)
    }
}
