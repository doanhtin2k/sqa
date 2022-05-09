package jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import model.Mon;
import model.Setting;
import model.User;

public class SettingDAO extends DAO{
	public Setting getByid(int id)
	{
		String sql ="SELECT * FROM settings WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			if(result.next())
			{
				Setting setting = new Setting();
				setting.setId(result.getInt("id"));
				setting.setName(result.getString("name"));
				setting.setCc(result.getInt("cc"));
				setting.setGk(result.getInt("gk"));
				setting.setCk(result.getInt("ck"));
//				System.out.println(user.getName() + " " + user.getCountry() + " " + user.getBirthday());
				return setting;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean updateSetting(Setting setting)
	{
		boolean result = false;
		String sql ="UPDATE settings SET cc=?, gk=?, ck=? WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, setting.getCc());
			ps.setInt(2, setting.getGk());
			ps.setInt(3, setting.getCk());
			ps.setInt(4, setting.getId());
			result = ps.executeUpdate() >0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
}
