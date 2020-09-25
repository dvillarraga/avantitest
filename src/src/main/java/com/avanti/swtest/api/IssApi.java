package com.avanti.swtest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avanti.swtest.logic.DistanceCalculator;
import com.avanti.swtest.logic.PositionCaller;
import com.avanti.swtest.model.ISSPosition;

@RestController
public class IssApi {

	@Autowired
	PositionCaller positionCaller;
	@Autowired
	DistanceCalculator distanceCalculator;
	
	@RequestMapping("/test")
    public String test() {
        return "Test app of Avanti is working!!! Cheers!!!";
    }
	
	/**
	 * 
	 * @param id  id If is is not sent as a param, it takes by default the iss=25544
	 * @return A pojo of the ISS position
	 */
	@RequestMapping("/currentposition")
    public ISSPosition getCurrentPosition(@RequestParam(value="id", defaultValue="25544") float id) {
		
		return positionCaller.getIssPosition(id);
    }
	
	/**
	 * 
	 * @param id If is is not sent as a param, it takes by default the iss=25544
	 * @param latitude If is is not sent as a param, it takes by default the London latitude=51.509865
	 * @param longitude If is is not sent as a param, it takes by default the London longitude=-0.118092
	 * @return the distance in Kilometers between the two pair of coordinates
	 */
	@RequestMapping("/calculatedistance")
    public double calculateDistance(@RequestParam(value="id", defaultValue="25544") float id, @RequestParam(value="latitude", defaultValue="51.509865") double latitude, @RequestParam(value="longitude", defaultValue="-0.118092") double longitude) {
		
		return distanceCalculator.getDistanceCalculationInKms(id, latitude, longitude);
    }
}
