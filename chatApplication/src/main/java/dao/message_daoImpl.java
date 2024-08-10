package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Utility.Connect;
import pojo.Register_Pojo;
import pojo.message_Pojo;

public class message_daoImpl {
	
	Connection con = Connect.getConnect();
	PreparedStatement ps;
	
	public boolean addMessage(message_Pojo message) {
		try {
			ps = con.prepareStatement("insert into messages(sid, name, message) values(?,?,?)");
			ps.setInt(1, message.getSid());
			ps.setString(2, message.getName());
			ps.setString(3, message.getMessage());
			int rs = ps.executeUpdate();
			if(rs!=0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;		
	}
	
	
	
	public List<message_Pojo> getMessagebyrid(int sid) {
		List<message_Pojo> li = new ArrayList<message_Pojo>();
		try {
			String q = "select message from messages where sid=?";
			ps = con.prepareStatement(q);
			ps.setInt(1, sid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				message_Pojo m = new message_Pojo();
				m.setMessage(rs.getString("message"));
				li.add(m);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return li;
	}

	public List<message_Pojo> getMessagebysid(int rid, int sid) {
		List<message_Pojo> li = new ArrayList<message_Pojo>();
		try {
			String q = "select message from message where rid=? and sid=?";
			ps = con.prepareStatement(q);
			ps.setInt(1, rid);
			ps.setInt(2, sid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				message_Pojo m = new message_Pojo();
				m.setMessage(rs.getString("message"));
				li.add(m);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return li;
	}
	
	public List<message_Pojo> getMessage(){
		List<message_Pojo> li = new ArrayList<message_Pojo>();
		try {
			ps = con.prepareStatement("select * from messages");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				message_Pojo m = new message_Pojo();
				m.setId(rs.getInt(1));
				m.setSid(rs.getInt(2));
				m.setName(rs.getString(3));
				m.setMessage(rs.getString(4));
				li.add(m);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return li;		
	}

}
