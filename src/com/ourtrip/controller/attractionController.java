package com.ourtrip.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ourtrip.dto.Gugun;
import com.ourtrip.dto.Sido;
import com.ourtrip.service.attractionService;
import com.ourtrip.service.attractionServiceImpl;

public class attractionController {

	private attractionService service;
	
	public attractionController() {
		this.service = new attractionServiceImpl();
	}
	
	public void getSidoList(HttpServletRequest request, HttpServletResponse response) {
		
		List<Sido> list = service.getSidoList();
		
		try {
            response.setContentType("application/json;charset=utf-8");
            Gson gson = new Gson();
            String s = gson.toJson(list);
            response.getWriter().print(s);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public void getGugunList(HttpServletRequest request, HttpServletResponse response) {
		
		int sidoCode = Integer.parseInt(request.getParameter("sido"));
		List<Gugun> list = service.getGugunList(sidoCode);
		
		try {
            response.setContentType("application/json;charset=utf-8");
            Gson gson = new Gson();
            String s = gson.toJson(list);
            response.getWriter().print(s);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
