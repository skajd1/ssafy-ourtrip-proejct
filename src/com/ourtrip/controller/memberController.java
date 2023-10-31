package com.ourtrip.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ourtrip.dto.memberDto;
import com.ourtrip.service.memberService;
import com.ourtrip.service.memberServiceImpl;

public class memberController {
	memberService ms;
	public memberController() {
		ms = new memberServiceImpl();
	}
	
	public void login(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(req.getMethod().equals("GET")) {
			forward(req,res,"/member/login.jsp");
		}
		else {
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			if(ms.login(id,pw)) {
				req.getSession().setAttribute("id", id);
				req.getSession().setAttribute("user", true);
				redirect(req,res,"/index.jsp");
			}
			else {
				req.setAttribute("msg", "아이디 또는 비밀번호가 틀렸습니다.");
				forward(req,res,"/member/login.jsp");
			}
		}
	}
	public void logout(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getSession().invalidate();
		forward(req,res,"/index.jsp");
	}

	public void regist(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		if(req.getMethod().equals("GET")) {
			forward(req,res,"/member/regist.jsp");
		}
		else {
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String domain = req.getParameter("domain");
			ms.regist(new memberDto(id,pw,name,email,domain));
			redirect(req,res,"/index.jsp");		
		}
	}
	public void delete(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		String id = req.getParameter("id");
		ms.delete(id);
		forward(req,res,"/index.jsp");				
	}
	public void mypage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		memberDto member = ms.getMember(req.getSession().getAttribute("id").toString());
		if(req.getMethod().equals("GET")) {
			req.setAttribute("member", member);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/member/mypage.jsp");
			forward(req,res,"/member/mypage.jsp");
		}
		else {
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			String name = req.getParameter("name");
			
			String email = req.getParameter("email");
			String domain = req.getParameter("domain");
			ms.update(req.getSession().getAttribute("id").toString(),new memberDto(id,pw,name,email,domain));
			redirect(req,res,"/index.jsp");		
		}
	}
	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		response.sendRedirect(request.getContextPath() + path);
	}

}
