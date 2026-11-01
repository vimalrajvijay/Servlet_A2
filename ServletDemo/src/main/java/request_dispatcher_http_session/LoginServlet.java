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

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		if("admin".equals(username) && "admin123".equals(password)) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			pw.println("Login Successfull");
//			 RequestDispatcher rd = req.getRequestDispatcher("home");
//			 rd.forward(req, resp);
		}else {
			RequestDispatcher rd1 = req.getRequestDispatcher("login.html");
			RequestDispatcher rd2 = req.getRequestDispatcher("error.html");
			
			rd1.include(req, resp);
			rd2.include(req, resp);
		}
	}
}
