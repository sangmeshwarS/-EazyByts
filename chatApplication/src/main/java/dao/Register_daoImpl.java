package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Utility.Connect;
import pojo.Register_Pojo;

public class Register_daoImpl {
	
	Connection con = Connect.getConnect();
	PreparedStatement ps;
	
	public boolean addUser(Register_Pojo r) {
		try {
			ps = con.prepareStatement("insert into register(name, email, phoneNumber, password) values(?,?,?,?)");
			ps.setString(1, r.getName());
			ps.setString(2, r.getEmail());
			ps.setString(3, r.getPhoneNumber());
			ps.setString(4, r.getPassword());
			int i =	ps.executeUpdate();
			if(i>0) {
				return true;
			}
			else {
				return false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Register_Pojo> getUser(){
		List<Register_Pojo> li = new ArrayList<Register_Pojo>();
		try {
			ps = con.prepareStatement("select * from register");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Register_Pojo r = new Register_Pojo();
				r.setId(rs.getInt(1));
				r.setName(rs.getString(2));
				r.setEmail(rs.getString(3));
				r.setPhoneNumber(rs.getString(4));
				r.setPassword(rs.getString(5));
				li.add(r);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return li;		
	}

}
