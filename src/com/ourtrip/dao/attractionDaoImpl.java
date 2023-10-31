package com.ourtrip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ourtrip.dto.Gugun;
import com.ourtrip.dto.Sido;
import com.ourtrip.util.DBUtil;

public class attractionDaoImpl implements attractionDao {

	private DBUtil util;
	
	public attractionDaoImpl() {
		this.util = DBUtil.getInstance();
	}
	
	
	
	public List<Sido> getSidoList() {
		
		String sql = "SELECT * FROM sido";
		List<Sido> list = new ArrayList<>();
		
		try {
			Connection con = util.getConnection();
			
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				int code = rs.getInt(1);
				String name = rs.getString(2);
				
				list.add(new Sido(code, name));
			}
			
			rs.close();
			stat.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<Gugun> getGugunList(int sidoCode) {
		
		String sql = "SELECT * FROM gugun WHERE sido_code = ?";
		List<Gugun> list = new ArrayList<>();
		
		try {
			Connection con = util.getConnection();
			
			PreparedStatement stat = con.prepareStatement(sql);
			stat.setInt(1, sidoCode);
			
			ResultSet rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				int code = rs.getInt(1);
				String name = rs.getString(2);
				int sido = rs.getInt(3);
				
				list.add(new Gugun(code, name, sido));
			}
			
			rs.close();
			stat.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
}
