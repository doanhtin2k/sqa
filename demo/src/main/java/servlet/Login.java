package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import jdbc.dao.AdminDAO;
import jdbc.dao.UserDAO;
import model.Admin;
import model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("abc");
		HttpSession session = request.getSession();
		if(session.getAttribute("admin")==null)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("Demo");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username"); 
		String password = request.getParameter("password"); 
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		AdminDAO adminDAO = new AdminDAO();
		
		if(adminDAO.login(admin)==null)
		{
			request.setAttribute("error", "Sai tài khoản hoặc mật khẩu");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
			return;
		}else {
			Admin u = adminDAO.login(admin);
			HttpSession session = request.getSession();
			session.setAttribute("admin", u);
			session.setAttribute("success", "Đăng nhập thành công");
		
			response.sendRedirect("Demo");
		}
	}

}
