package jdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import model.User;

public class UserDAO extends DAO{
	
	public Boolean addUser(User user)
	{
		boolean result = false;
		String sql ="INSERT INTO users(name,masv,khoa,password,birthday,country) VALUES (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getMasv());
			ps.setInt(3, user.getKhoa());
			ps.setString(4, user.getPassword());
			Date date = user.getBirthday();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			ps.setDate(5, sqlDate);
			ps.setString(6, user.getCountry());
			result = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public ArrayList<User> getAll()
	{
		ArrayList<User> listUser = new ArrayList<User>();
		String sql ="SELECT * FROM users";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			while(result.next())
			{
				User user = new User();
				user.setId(result.getInt("id"));
				user.setName(result.getString("name"));
				user.setMasv(result.getString("masv"));
				user.setKhoa(result.getInt("khoa"));
				user.setPassword(result.getString("password"));
				Date date = new Date(result.getDate("birthday").getTime());
				user.setBirthday(date);
				user.setCountry(result.getString("country"));
				listUser.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listUser;
	}
	
	public boolean deleteUser(User user)
	{
		boolean result = false;
		String sql ="DELETE FROM users WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());	
			result = ps.executeUpdate() >0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	public boolean updateUser(User user)
	{
		boolean result = false;
		String sql ="UPDATE users SET name=?, masv=?, khoa=?, password=?, birthday=?, country=?  WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getMasv());
			ps.setInt(3, user.getKhoa());
			ps.setString(4, user.getPassword());
			Date date = user.getBirthday();
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			ps.setDate(5, sqlDate);
			ps.setString(6, user.getCountry());
			ps.setInt(7, user.getId());
			result = ps.executeUpdate() >0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
//	
//	public User getByUserName(String username)
//	{
//		String sql ="SELECT * FROM users WHERE username =?";
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			ps.setString(1, username);
//			ResultSet rs = ps.executeQuery();
//			if(rs.next())
//			{
//				User user = new User();
//				user.setId(rs.getInt("id"));
//				user.setUsername(rs.getString("username"));
//				user.setPassword(rs.getString("password"));
//				user.setAvatar(rs.getString("avatar"));
//				user.setEmail(rs.getString("email"));
//				StudentDAO studao = new StudentDAO();
//				Student stu = studao.getbyStudentCode(rs.getString("studentCode"));
//				user.setStudent(stu);
//				return user;
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;	
//	}
	public User getById(int id)
	{
		
		String sql ="SELECT * FROM users WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();
			if(result.next())
			{
				User user = new User();
				user.setId(result.getInt("id"));
				user.setName(result.getString("name"));
				user.setMasv(result.getString("masv"));
				user.setKhoa(result.getInt("khoa"));
				user.setPassword(result.getString("password"));
				Date date = new Date(result.getDate("birthday").getTime());
				user.setBirthday(date);
				user.setCountry(result.getString("country"));
				System.out.println(user.getName() + " " + user.getCountry() + " " + user.getBirthday());
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
//	public static void main(String args[])
//	{
//		UserDAO udao = new UserDAO();
//		User user = new User();
//		user.setUsername("admin1");
//		user.setPassword("123456");
//		if(udao.login(user)==null)
//		{
//			System.out.println("fail");
//		}else {
//			System.out.println("true");
//		}
//		
//	}
}



