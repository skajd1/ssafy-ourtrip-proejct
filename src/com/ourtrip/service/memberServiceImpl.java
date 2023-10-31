package com.ourtrip.service;

import java.util.ArrayList;

import com.ourtrip.dao.memberDao;
import com.ourtrip.dao.memberDaoImpl;
import com.ourtrip.dto.memberDto;

public class memberServiceImpl implements memberService {
	
	memberDao dao;
	public memberServiceImpl() {
		dao = new memberDaoImpl();
	}

	@Override
	public boolean login(String id, String pw) {
		return dao.checkIdPw(id,pw);
	}

	@Override
	public void regist(memberDto member) {
		dao.regist(member);
	}

	@Override
	public void delete(String id) {
		dao.mdelete(id);
	}

	@Override
	public void update(String targetId, memberDto member) {
		dao.mupdate(targetId, member);
	}

	@Override
	public ArrayList<memberDto> getAllMembers() {
		ArrayList<memberDto> list = dao.selectAll();
		return list;
	}

	@Override
	public memberDto getMember(String id) {
		memberDto member = dao.selectOne(id);
		return member;
	}

}
