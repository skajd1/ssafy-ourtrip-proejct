package com.ourtrip.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class FrontController extends HttpServlet {
	memberController mcon;
	attractionController acon;
	public FrontController() {
		mcon = new memberController();
		acon = new attractionController();
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String url = request.getServletPath();
		if(url.equals("/login"))
			mcon.login(request,response);
		else if(url.equals("/logout"))	
			mcon.logout(request,response);
		else if(url.equals("/regist"))	
			mcon.regist(request,response);
		else if(url.equals("/withdraw"))	
			mcon.delete(request,response);
		else if(url.equals("/mypage"))
			mcon.mypage(request,response);
		else if(url.equals("/attraction/sido")) {
			acon.getSidoList(request, response);
			
		}else if(url.equals("/attraction/gugun")) {
			acon.getGugunList(request, response);
		}
		else if(url.equals("/index") || url.equals("/"))
			forward(request, response, "/index.jsp");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	private void forward(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
