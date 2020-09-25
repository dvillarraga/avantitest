package com.avanti.swtest.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyFloat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.avanti.swtest.api.IssApi;
import com.avanti.swtest.logic.DistanceCalculator;
import com.avanti.swtest.logic.PositionCaller;
import com.avanti.swtest.model.ISSPosition;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IssApiTest {
	
	private final double testingDistance = 245.6588;
	private final double currentLatTest = 87654.4566;
	private final double currentLonTest = 8765.234;
	private final double delta = 0.5;
	
	@Mock
	PositionCaller positionCaller;
	@Mock
	DistanceCalculator distanceCalculator;
	
	@InjectMocks
	IssApi issApi;
	
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		when(distanceCalculator.getDistanceCalculationInKms(anyFloat(), anyDouble(), anyDouble())).thenReturn(testingDistance);
		when( positionCaller.getIssPosition(anyFloat())).thenReturn( new ISSPosition(currentLonTest, currentLatTest, "ISS", 25544) );
	}
	
	@Test
	public void calculateDistanceTest() {
		assertNotNull("Problems mocking the entry point instance ISSApi",issApi);
		double calculadteDistance = issApi.calculateDistance(anyFloat(), anyDouble(), anyDouble());
		assertEquals("Calculate distance NOT working", testingDistance, calculadteDistance,0.5);
	}
	
	@Test
	public void currentPositionTest() {
		assertNotNull("Problems mocking the entry point instance ISSApi",issApi);
		ISSPosition issCurrentPosition = issApi.getCurrentPosition(anyFloat());
		assertEquals("Problems in IssApi calculating current latitude", currentLatTest, issCurrentPosition.getLatitude(), delta);
		assertEquals("Problems in IssApi calculating current longitude", currentLonTest, issCurrentPosition.getLongitude(), delta);
	}
	
}
