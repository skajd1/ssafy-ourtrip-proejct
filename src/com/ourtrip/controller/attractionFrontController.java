package com.ourtrip.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/attraction")
public class attractionFrontController extends HttpServlet {
	
	private attractionController acon;
       
    public attractionFrontController() {
    	acon = new attractionController();
    }

private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");//한글처리
		
		String reqString = request.getServletPath();//입력한 url의 제일 마지막 /뒷부분이 나옴
		if(reqString.equals("/sido")) {
			acon.getSidoList(request, response);
			
		}else if(reqString.equals("/gugun")) {
			acon.getGugunList(request, response);
		}
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
