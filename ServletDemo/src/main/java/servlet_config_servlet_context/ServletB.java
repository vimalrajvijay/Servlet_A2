package servlet_config_servlet_context;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = "/servletB",
		initParams = @WebInitParam(name="age",value="21")
		)
public class ServletB extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		String age = config.getInitParameter("age");
		
		ServletContext context= getServletContext();
		String email = context.getInitParameter("email");
		
		PrintWriter pw = resp.getWriter();
		pw.println("Age   : "+age);
		pw.println("Email : "+email);
	}
}
