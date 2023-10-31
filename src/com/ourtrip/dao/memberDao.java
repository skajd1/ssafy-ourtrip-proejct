package com.ourtrip.dao;

import java.util.ArrayList;

import com.ourtrip.dto.memberDto;

public interface memberDao {
	
	//멤버 전체 select
	public ArrayList<memberDto> selectAll();
	
	public memberDto selectOne(String id);
	
	//파라미터로 들어온 아이디 비번 맞나 체크
	public boolean checkIdPw(String id, String pw);
	
	//id 중복 체크
	public boolean idDupCheck(String id);
	
	//insert
	public boolean minsert(memberDto member);
	
	//중복 없으면 가입
	public void regist(memberDto member);
	
	//회원 정보 수정
	public void mupdate(String targetId, memberDto member);
	
	//회원 탈퇴
	public void mdelete(String id);
	
	

}
