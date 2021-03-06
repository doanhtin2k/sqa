package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdbc.dao.ScoreDAO;
import jdbc.dao.SettingDAO;
import jdbc.dao.UserDAO;
import model.Setting;
import model.User;

/**
 * Servlet implementation class Score
 */
@WebServlet("/Score")
public class Score extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Score() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("userId"));
		ScoreDAO sd = new ScoreDAO();
		ArrayList<model.Score> list_score = sd.getListScoreByUserId(id);
		
		SettingDAO stdao = new SettingDAO();
		Setting st  = stdao.getByid(1);
		float cc = (float) (st.getCc()/100.0);
		float gk = (float) (st.getGk()/100.0);
		float ck = (float) (st.getCk()/100.0);
		for(int i=0; i<list_score.size(); i++)
		{
			if(list_score.get(i).getStatus() == 0)
			{
				float tk = list_score.get(i).getDiemcc() * cc + list_score.get(i).getDiemgiuaky() * gk + list_score.get(i).getDiemcuoiky() * ck;
				tk = (float) Math.round(tk * 100) / 100;
				list_score.get(i).setDiemtongket(tk);
			}
		}
		request.setAttribute("list_score", list_score);
		request.setAttribute("userId", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("score/index.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		System.out.println(userId);
		
		
		ScoreDAO sd = new ScoreDAO();
		ArrayList<model.Score> list_score = sd.getListScoreByUserId(userId);
		
		SettingDAO stdao = new SettingDAO();
		Setting st  = stdao.getByid(1);
		float cc = (float) (st.getCc()/100.0);
		float gk = (float) (st.getGk()/100.0);
		float ck = (float) (st.getCk()/100.0);
		for(int i=0; i<list_score.size(); i++)
		{
			if(list_score.get(i).getStatus() == 0)
			{
				float tk = list_score.get(i).getDiemcc() * cc + list_score.get(i).getDiemgiuaky() * gk + list_score.get(i).getDiemcuoiky() * ck;
				tk = (float) Math.round(tk * 100) / 100;
				list_score.get(i).setDiemtongket(tk);
				sd.updateTongKetById(list_score.get(i));
			}
		}
		HttpSession session = request.getSession();
		session.setAttribute("success", "luu thanh cong");
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
