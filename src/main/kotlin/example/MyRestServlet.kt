package example

import io.javalin.EmbeddedJavalin
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(urlPatterns = ["/rest/*"], name = "MyRestServlet", asyncSupported = false)
class MyRestServlet : HttpServlet() {
    val javalin = EmbeddedJavalin()
            .get("/rest") { ctx -> ctx.result("Hello!") }
            .createServlet()

    override fun service(req: HttpServletRequest, resp: HttpServletResponse) {
        javalin.service(req, resp)
    }
}
