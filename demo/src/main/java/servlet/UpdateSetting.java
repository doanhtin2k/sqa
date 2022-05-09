package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.dao.SettingDAO;
import model.Setting;

/**
 * Servlet implementation class EditSetting
 */
@WebServlet("/UpdateSetting")
public class UpdateSetting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSetting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SettingDAO stDAO = new SettingDAO();
		model.Setting st = stDAO.getByid(1);
		request.setAttribute("setting", st);
		RequestDispatcher dispatcher =request.getRequestDispatcher("setting/update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int cc = Integer.parseInt(request.getParameter("cc"));
		int gk = Integer.parseInt(request.getParameter("gk"));
		int ck = Integer.parseInt(request.getParameter("ck"));
		
		request.setAttribute("error_cc", "");
		request.setAttribute("error_gk", "");
		request.setAttribute("error_ck", "");
		request.setAttribute("error_sum", "");
		int error= 0;
		if(cc <= 0)
		{
			request.setAttribute("error_cc", "Chuyen can khong nho hon hoac bang 0");
			error = 1;
		}
		if(gk <= 0)
		{
			request.setAttribute("error_gk", "Giua ky khong nho hon hoac bang 0");
			error = 1;
		}
		if(ck <= 0)
		{
			request.setAttribute("error_ck", "Cuoi ky khong nho hon hoac bang 0");
			error = 1;
		}
		if(cc+ gk + ck != 100)
		{
			request.setAttribute("error_sum", "tong phai bang 100");
			error = 1;
		}
		System.out.println(cc + " " + gk + " " + ck);
		if(error == 0)
		{
			SettingDAO stdao = new SettingDAO();
			Setting st = stdao.getByid(1);
			st.setCc(cc);
			st.setGk(gk);
			st.setCk(ck);
			if(stdao.updateSetting(st))
			{
				HttpSession session = request.getSession();
				session.setAttribute("success", "Cap nhat cau hinh thanh cong");
					 response.sendRedirect("Setting");
					 return;
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("error", "Cap nhat cau hinh that bai");
					 response.sendRedirect("Setting");
					 return;
			}
		}else {
			doGet(request, response);
		}
		
	}

}
