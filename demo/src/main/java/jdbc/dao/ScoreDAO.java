package jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Mon;
import model.Score;
import model.User;

public class ScoreDAO extends DAO{
	public Boolean addUser(Score score)
	{
		boolean result = false;
		String sql ="INSERT INTO scores(diemcc,diemgiuaky,diemcuoiky,monhocid,usersid,status) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setFloat(1, score.getDiemcc());
			ps.setFloat(2, score.getDiemgiuaky());
			ps.setFloat(3, score.getDiemcuoiky());
			ps.setInt(4, score.getMon().getId());
			ps.setInt(5, score.getUser().getId());
			ps.setInt(6, 0);
			result = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return result;
	}
	public Boolean updateTongKetById(Score score)
	{
		boolean result = false;
		String sql ="Update scores SET diemtongket=?, status=1 WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setFloat(1, score.getDiemtongket());
			ps.setInt(2, score.getId());

			result = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return result;
	}
	public ArrayList<Score> getListScoreByUserId(int userId)
	{
		ArrayList<Score> list_score = new ArrayList<Score>();
		UserDAO  ud = new UserDAO();
		MonDAO md = new MonDAO();
		String sql ="SELECT * FROM scores WHERE usersid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet result = ps.executeQuery();
			while(result.next())
			{
				Score score = new Score();
				score.setId(result.getInt("id"));
				score.setDiemcc(result.getFloat("diemcc"));
				score.setDiemgiuaky(result.getFloat("diemgiuaky"));
				score.setDiemcuoiky(result.getFloat("diemcuoiky"));
				score.setDiemtongket(result.getFloat("diemtongket"));
				score.setStatus(result.getInt("status"));
				Mon mon = md.getByid(result.getInt("monhocid"));
				User u = ud.getById(result.getInt("usersid"));
				score.setMon(mon);
				score.setUser(u);
				list_score.add(score);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list_score;
	}
	public ArrayList<Score> getListScoreByMonId(int monId)
	{
		ArrayList<Score> list_score = new ArrayList<Score>();
		UserDAO  ud = new UserDAO();
		MonDAO md = new MonDAO();
		String sql ="SELECT * FROM scores WHERE monhocid=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, monId);
			ResultSet result = ps.executeQuery();
			while(result.next())
			{
				Score score = new Score();
				score.setId(result.getInt("id"));
				score.setDiemcc(result.getFloat("diemcc"));
				score.setDiemgiuaky(result.getFloat("diemgiuaky"));
				score.setDiemcuoiky(result.getFloat("diemcuoiky"));
				score.setDiemtongket(result.getFloat("diemtongket"));
				score.setStatus(result.getInt("status"));
				Mon mon = md.getByid(result.getInt("monhocid"));
				User u = ud.getById(result.getInt("usersid"));
				score.setMon(mon);
				score.setUser(u);
				list_score.add(score);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list_score;
	}
//	public static void main(String[] args)
//	{
//		ScoreDAO sd = new ScoreDAO();
//		ArrayList<Score> list = sd.getListScoreByUserId(7);
//		System.out.println(list.size());
//	}
}
