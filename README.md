# Features

- Developed in Springboot and gradle;
- Once the app is running, it offers the two URLs to offer the services of calculating the distance and the current position of the ISS;
- The current position service URL is: http://localhost:8080/currentposition. If the id parameter is not given, it takes by default the id of the ISS.
- The distance calculation service URL is: http://localhost:8080/calculatedistance. If no latitude or longitude are given, it takes the London coordinates to make the calculation. If so, just type latitude and longitude with their corresponding values.
- Division of the artifact code in api, logic and business.
### JUNIT - Unitary Tests
- The project has JUNIT tests, to validate the code most important capabilities like the calculation of the distance and the invokation of the two services.
- The test folder structure is the same as the production code folder, to bring a better structure in each test.
- The verification of the distance calculation was taken from https://www.geodatasource.com/distance-calculator

# Future work
- Work on handling exception codes(http codes) in any case our app fails or the invokation of the external api does.
- Reach 100% code coverage to ensure each line is working properly,


![](http://explorecuriocity.org/Portals/4/Resource-Images/6406.jpg)