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
		urlPatterns = "/servletA", 
		initParams = @WebInitParam(name="name", value="abc"))
public class ServletA extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 ServletConfig config = getServletConfig();
		 String name = config.getInitParameter("name");
		 
		 ServletContext context= getServletContext();
		 String email = context.getInitParameter("email");
		 
		 PrintWriter pw = resp.getWriter();
		 pw.println("Name  : "+name);
		 pw.println("Email : "+email);
	}
}
