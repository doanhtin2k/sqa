package jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Admin;
import model.User;

public class AdminDAO extends DAO{
	public Admin login(Admin admin)
	{
		String sql ="SELECT * FROM admins WHERE username=? AND password=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getPassword());
			ResultSet rs= ps.executeQuery();
			if(rs.next())
			{
				admin.setId(rs.getInt("id"));
				return admin;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
