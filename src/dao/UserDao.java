package dao;
import vo.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;
public class UserDao {
	public static User get(String userName) {
		User user = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usersql?useuricode=true&character=utf-8","root","");
			if(con != null)
			{
				System.out.println("Ok");//���һ���Ƿ������MySQL
			}
			else
			{
				System.out.println("no");
			}
			String sql = "select * from userfont where userName=?";
			PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
			pst.setNString(1,userName);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				user=new User(rs.getString("userName"),rs.getString("password"),rs.getString("chrName"),rs.getString("role"));
			}
			con.close();
		}
		catch (Exception e) {
			
		}
		return user;
	}
	
	public User get(String userName,String password) {
		User user = null;
		
		return user;
	}
}
