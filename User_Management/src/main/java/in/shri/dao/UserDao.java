package in.shri.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class UserDao {
	private String url="jdbc:mysql://localhost:3306/usermanage";
	private String user="root";
	private String pass="root";
	private String jdbcDriver="com.mysql.cj.jdbc.Driver";
	
	private static final String insert="insert into users"+"(name,email,country) values"+"(?,?,?);";
	private static final String select="select * from users where id=?";
	private static final String select_id="select id,name,email,country from users where id=?";
	private static final String delete="select from users where id=?";
	private static final String update="update users set name=?, email=?, country=? where id=?";
	
	public UserDao() {
		
	}
	
	protected Connection getConnection() {
		Connection con=null;
		try {
			Class.forName(jdbcDriver);
			con=DriverManager.getConnection(url,user,pass);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		return con;
	}
}
