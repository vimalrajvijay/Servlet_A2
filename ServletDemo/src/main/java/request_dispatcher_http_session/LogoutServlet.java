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

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 HttpSession session = req.getSession();
		 String username = (String)session.getAttribute("username");
		 PrintWriter pw = resp.getWriter();
		 resp.setContentType("text/html");
		 if(username!=null) {
			session.invalidate();
			pw.println("Logged out successfully");
		}else {
			pw.println("Login first");
			RequestDispatcher rd1 = req.getRequestDispatcher("login.html");
			rd1.include(req, resp);
		}
	}
}
