package com.ourtrip.dao;

import java.util.List;

import com.ourtrip.dto.Gugun;
import com.ourtrip.dto.Sido;

public interface attractionDao {

	public List<Sido> getSidoList();
	
	public List<Gugun> getGugunList(int sidoCode);
}
