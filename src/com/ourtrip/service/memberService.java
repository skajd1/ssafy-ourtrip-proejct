package com.ourtrip.service;

import java.util.ArrayList;

import com.ourtrip.dto.memberDto;

public interface memberService {
	public boolean login(String id, String pw);
	public void regist(memberDto member);
	public void delete(String id);
	public void update(String targetId, memberDto member);
	public ArrayList<memberDto> getAllMembers();
	public memberDto getMember(String id);

}
