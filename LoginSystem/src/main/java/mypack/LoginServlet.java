package mypack;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String name=req.getParameter("name1");
		String pass=req.getParameter("pass1");
		
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		
		HttpSession session=req.getSession();
		session.setAttribute(name,"Seema");
		session.setAttribute(pass,"Seema@123");
		
		if(name.equals("Seema") && pass.equals("Seema@123"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("Welcome.jsp");
			rd.forward(req, resp);
		}
		else
		{
			out.print("<h1>Username and passord are not correct...!</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
			rd.include(req, resp);
		}
	}
}
