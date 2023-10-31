package com.ourtrip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ourtrip.dto.memberDto;
import com.ourtrip.util.DBUtil;

public class memberDaoImpl implements memberDao{
	DBUtil db;
	public memberDaoImpl() {
		db = DBUtil.getInstance();
	}
	

	@Override
	public boolean checkIdPw(String id, String pw) {
		
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = db.getConnection();
			String q = "select * from members where user_id = ? and user_password = ?";
			ps = conn.prepareStatement(q);
			ps.setString(1, id);
			ps.setString(2, pw);
			if(ps.executeQuery().next()) result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(conn,ps);
		}
		return result;
	}

	@Override
	public boolean idDupCheck(String id) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = db.getConnection();
			
			String q = "select user_id from members where user_id = ?";
			ps = conn.prepareStatement(q);
			ps.setString(1, id);
			if(ps.executeQuery().next()) result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(conn,ps);
		}
		return result;
	}

	@Override
	public boolean minsert(memberDto member) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = db.getConnection();			
			String id = member.getId();
			String name = member.getName();
			String pw = member.getPw();
			String email = member.getEmail();
			String domain = member.getDomain();
			String q = "insert into members (user_id, user_name, user_password, email_id, email_domain) ";
			q += "values(?,?,?,?,?);";
			
			ps = conn.prepareStatement(q);
			int i = 0;
			ps.setString(++i, id);
			ps.setString(++i, name);
			ps.setString(++i, pw);
			ps.setString(++i, email);
			ps.setString(++i, domain);
			int r = ps.executeUpdate();
			if(r!=0) result = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(conn,ps);
		}
		return result;
	}

	@Override
	public void mupdate(String targetId, memberDto member) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = db.getConnection();			
			
			String name = member.getName();
			String pw = member.getPw();
			String q = "update members set user_name = ?, user_password = ? ";
			q += "where user_id = "+ targetId +";";
			
			ps = conn.prepareStatement(q);
			int i = 0;
			
			ps.setString(++i, name);
			ps.setString(++i, pw);
			
			System.out.println(name + " name ");
			System.out.println(pw + " pw ");
			System.out.println(targetId + " id ");
			System.out.println(ps.executeUpdate());
			System.out.println(q);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(conn,ps);
		}
		
	}

	@Override
	public void mdelete(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = db.getConnection();			
			
			String q = "delete from members where user_id = ?;";
			ps = conn.prepareStatement(q);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(conn,ps);
		}
	}

	//회원가입 트랜잭션 및 예외처리
	@Override
	public void regist(memberDto member) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = db.getConnection();
			conn.setAutoCommit(false);
			
			boolean checkDup = idDupCheck(member.getId());
			if(checkDup) throw new Exception("아이디가 중복이에요");
			if(!minsert(member)) throw new Exception("회원가입에 실패했어요");

			conn.commit();
		} catch (Throwable e) {
			if(conn!= null){
				try{
					conn.rollback();
				}
				catch(SQLException e1){
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
			e.printStackTrace();
			}
			db.close(conn,ps);
		}
	}


	@Override
	public ArrayList<memberDto> selectAll() {
		ArrayList<memberDto> members = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			String q = "select * from members";
			ps = conn.prepareStatement(q);
			rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String pw = rs.getString(3);
				String email = rs.getString(4);
				String domain = rs.getString(5);
				String jdate = rs.getString(6);
				members.add(new memberDto(id,name,pw,email,domain,jdate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			db.close(conn,ps,rs);
		}
		return members;
	}


	@Override
	public memberDto selectOne(String id) {
		memberDto member = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = db.getConnection();
			String q = "select * from members where user_id = ?";
			ps = conn.prepareStatement(q);
			ps.setString(1, id);
			rs = ps.executeQuery();
			rs.next();
			String name = rs.getString(2);
			String pw = rs.getString(3);
			String email = rs.getString(4);
			String domain = rs.getString(5);
			String jdate = rs.getString(6);
			member = new memberDto(id,name,pw,email,domain,jdate);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			db.close(conn,ps,rs);
		}
		return member;
		
		
	}
}
