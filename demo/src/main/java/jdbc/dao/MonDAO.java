package jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Mon;


public class MonDAO extends DAO{
	public ArrayList<Mon> getAll() {
		ArrayList<Mon> listMon= new ArrayList<Mon>();
		String sql ="SELECT * FROM monhoc";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			while(result.next())
			{
				Mon mon = new Mon();
				mon.setId(result.getInt("id"));
				mon.setName(result.getString("name"));
				mon.setSotinchi(result.getInt("sotinchi"));
				listMon.add(mon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listMon;
	}
	public Mon getByid(int id)
	{
		String sql ="SELECT * FROM monhoc WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			if(result.next())
			{
				Mon mon = new Mon();
				mon.setId(result.getInt("id"));
				mon.setName(result.getString("name"));
				mon.setSotinchi(result.getInt("sotinchi"));
//				System.out.println(user.getName() + " " + user.getCountry() + " " + user.getBirthday());
				return mon;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
