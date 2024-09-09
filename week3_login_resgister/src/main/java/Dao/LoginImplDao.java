package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import models.Users;

public class LoginImplDao implements ILoginDao {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public void resgister(Users user) {
		String sql ="insert into Users(name,email,password,phone_number)  values (?,?,?,?)";
		try {
			conn = new DBConectionSQLServer().getConnection(); // Kết nối CSDL
			ps = conn.prepareStatement(sql);// phat bieu cau sql trong prepare
			ps.setString(1, user.getName());// thiet lap gia tri cho tham so ?
			ps.setString(2, user.getEmail());// thiet lap gia tri cho tham so ? thu hai
			ps.setString(3,user.getPassword());
			ps.setString(4,user.getPhoneNumber());
			ps.executeUpdate();// thuc thi sql
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public boolean login(String username, String password) {
		String sql="SELECT password FROM users WHERE email = ?";
		boolean isValue=false;
		try {
			Connection conn = new DBConectionSQLServer().getConnection(); // Kết nối CSDL
			PreparedStatement ps = conn.prepareStatement(sql);// phat bieu cau sql trong prepare
			ps.setString(1, username);// thiet lap gia tri cho tham so ?
			
			rs = ps.executeQuery();
			while (rs.next()) {
				String valuePass=rs.getString("password");
				isValue = valuePass.equals(password);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValue;
	}
	
}
