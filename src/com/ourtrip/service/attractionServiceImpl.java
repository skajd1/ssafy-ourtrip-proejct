package com.ourtrip.service;

import java.util.List;

import com.ourtrip.dao.attractionDao;
import com.ourtrip.dao.attractionDaoImpl;
import com.ourtrip.dto.Gugun;
import com.ourtrip.dto.Sido;


public class attractionServiceImpl implements attractionService {

	private attractionDao dao;
	
	public attractionServiceImpl() {
		this.dao = new attractionDaoImpl();
	}
	
	public List<Sido> getSidoList() {
		return dao.getSidoList();
	}
	
	public List<Gugun> getGugunList(int sidoCode) {
		return dao.getGugunList(sidoCode);
	}
}
