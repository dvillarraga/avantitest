package com.avanti.swtest.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.avanti.swtest.api.ISSInfoProvider;
import com.avanti.swtest.model.ISSPosition;

@Component
public class PositionCaller {

	@Autowired
	ISSInfoProvider wheretheissApiCaller;
	
	public ISSPosition getIssPosition(float id) {
		
		return wheretheissApiCaller.getISSPosition(id);
	}
	
}
