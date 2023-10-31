package com.ourtrip.service;

import java.util.List;

import com.ourtrip.dto.Gugun;
import com.ourtrip.dto.Sido;

public interface attractionService {

	
	
	
	
	public List<Sido> getSidoList();
	
	public List<Gugun> getGugunList(int sidoCode);
	
}
