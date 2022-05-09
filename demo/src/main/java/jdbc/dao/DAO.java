package jdbc.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	public static Connection conn;
	public DAO ()
	{
		if(conn==null)
		{
			final String dbUrl = "jdbc:mysql://localhost:3306/sqa?characterEncoding=UTF8";
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(dbUrl,"root","");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();				
			}
		}
	}
}
