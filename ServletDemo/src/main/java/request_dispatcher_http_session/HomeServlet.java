package request_dispatcher_http_session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home")
public class HomeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session = req.getSession();
		 String username = (String)session.getAttribute("username");
		 resp.setContentType("text/html");
		 PrintWriter pw = resp.getWriter();
		 if(username!=null) {
			pw.println("<h1> Home page </h1>");
		}else {
			pw.println("Login first");
			RequestDispatcher rd1 = req.getRequestDispatcher("login.html");
			rd1.include(req, resp);
		}
	}
}
