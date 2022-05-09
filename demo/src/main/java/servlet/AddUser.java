package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.dao.UserDAO;
import model.User;


/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user/createUser.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (String) request.getParameter("name");
		String masv = (String) request.getParameter("masv");
		String khoaString =  request.getParameter("khoa");
				
		String password = (String) request.getParameter("password");
		String birthdayString = (String)request.getParameter("birthday").replace("-", "/");
		System.out.println(birthdayString);
		String country = (String) request.getParameter("country");
		int error= 0;
		request.setAttribute("name", "");
		request.setAttribute("masv", "");
		request.setAttribute("khoa", "");
		request.setAttribute("password", "");
		request.setAttribute("birthday", "");
		request.setAttribute("country", "");
		
		if(country.equals(""))
		{
			request.setAttribute("country", "country khong duoc de trong");
			error =1;
		}
		if(birthdayString.equals("")){
			request.setAttribute("birthday", "birthday khong duoc de trong");
			error =1;
		}
		if(password.equals(""))
		{
			request.setAttribute("password", "password khong duoc de trong");
			error =1;
			//error = "";
		}
		if (khoaString.equals(""))
		{
			request.setAttribute("khoa", "khoa khong duoc de trong");
			error =1;
			//error = "khoa khong duoc de trong";
		}
		if(masv.equals(""))
		{
			request.setAttribute("masv", "masv khong duoc de trong");
			error =1;
			//error = "";
		}
		if(name.equals(""))
		{
			request.setAttribute("name", "name khong duoc de trong");
			error = 1;
			//error = "";
		}
		if(error == 0)
		{
			System.out.println("abc");
			int khoa = Integer.parseInt(khoaString);
			Date birthday = new Date();
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
				birthday = formatter.parse(birthdayString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(birthday);
			UserDAO udao = new UserDAO();
			User user = new User(name, masv, khoa, password, birthday, country);
			if(udao.addUser(user))
			{
				HttpSession session = request.getSession();
				session.setAttribute("success", "Thêm User thành công");
				response.sendRedirect("ListUser");
				return;
			}
		}
		
		doGet(request, response);
	}

}
