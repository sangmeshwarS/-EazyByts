package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Utility.Connect;

public class Login_daoImpl {
	
	Connection con = Connect.getConnect();
	PreparedStatement ps;
	
	public boolean userLogin(String email, String password) {
		try {
			ps = con.prepareStatement("select * from register where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;		
	}
	
	public String getUsernamebyemail(String email) {
		String userName = null;
		try {
			String q = "select name from register where email=?";
			ps = con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				userName = rs.getString("name");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userName;
	}
	
	public String getUsernamebyId(int id) {
		String userName = null;
		try {
			String q = "select name from register where id=?";
			ps = con.prepareStatement(q);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				userName = rs.getString("name");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return userName;
	}
	
	public int getIdbyemail(String email) {
		int rid = 0;
		try {
			String q = "select id from register where email=?";
			ps = con.prepareStatement(q);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rid = rs.getInt("id");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rid;
	}

}
