package com.avanti.swtest.logic;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyFloat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.avanti.swtest.api.ISSInfoProvider;
import com.avanti.swtest.model.ISSPosition;

public class DistanceCalculatorTest {
	
	private final double currentLatTest = 200;
	private final double currentLonTest = 200;
	private final double delta = 0.3;
	private final double givenLatTest = 0;
	private final double givenLonTest = 0;
	/** Value gotten from https://www.geodatasource.com/distance-calculator*/
	private final double realResultInKmsTest = 3112.3;
	
	
	@InjectMocks
	DistanceCalculator distanceCalculator;
	
	@Mock
	ISSInfoProvider wheretheissApiCaller;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		when( wheretheissApiCaller.getISSPosition(anyFloat())).thenReturn( new ISSPosition(currentLonTest, currentLatTest, "ISS", 25544) );
	}
	
	@Test
	public void distanceCalculationInKmsTest() {
		double calculationInKms = distanceCalculator.getDistanceCalculationInKms(anyFloat(), givenLatTest, givenLonTest);
		assertEquals("Distance calculation not working!!!",realResultInKmsTest, calculationInKms,delta);
	}

}
