package com.avanti.swtest.api;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.avanti.swtest.model.ISSPosition;

@Component
public class WheretheissApiCaller implements ISSInfoProvider {
	
	/**
	 * It calls and parses the json answer in an object ISSPosition of the current iss position.
	 * @param id = Identification of the spacecraft
	 * @return ISSPosition position object with the info required
	 */
	public ISSPosition getISSPosition(float id) {

		RestTemplate restTemplate = new RestTemplate();
        ISSPosition issPosition = restTemplate.getForObject("https://api.wheretheiss.at/v1/satellites/"+id, ISSPosition.class);
        
        return issPosition;
	}
}
