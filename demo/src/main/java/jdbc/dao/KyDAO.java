package jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.User;
import model.Ky;

public class KyDAO extends DAO{
	public ArrayList<Ky> getAll() {
		ArrayList<Ky> listKy = new ArrayList<Ky>();
		String sql ="SELECT * FROM ky";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			while(result.next())
			{
				Ky ky = new Ky();
				ky.setId(result.getInt("id"));
				ky.setName(result.getString("name"));
				listKy.add(ky);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listKy;
	}
	public Ky getByid(int id)
	{
		String sql ="SELECT * FROM ky WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			if(result.next())
			{
				Ky ky = new Ky();
				ky.setId(result.getInt("id"));
				ky.setName(result.getString("name"));
//				System.out.println(user.getName() + " " + user.getCountry() + " " + user.getBirthday());
				return ky;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
