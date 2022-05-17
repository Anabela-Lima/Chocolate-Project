package com.bnta.chocolate;

import com.bnta.chocolate.Services.ChocolateService;
import com.bnta.chocolate.config.DBSeeder;
import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class ChocolateApplicationTests {


	@Autowired
	private ChocolateService chocolateService; // gluing  ChocolateRepository to test by creating an instance (object of type Chcolate Repository in test)
	@Autowired
	// gluing  ChocolateRepository to test by creating an instance (object of type Chcolate Repository in test)
	private ChocolateRepository chocolateRepository;

	@Autowired // gluing  EstateRepository  test by creating an instance (object of type EstateRepository in test)
	private EstateRepository estateRepository;




	// declaring variables before using them
	private Estate estate1;
	private Chocolate chocolate1;


	// a test to see if the query created in ChocolateRepository works
	@Test
	public void  cocoamoreThan60Querytest() {
//		  Estate estate6 = new Estate("AnaEstate", "Portugal");
//		  Chocolate chocolate1 = new Chocolate("CreamyCrunch",70, estate6);
//
		// chocolate 1 is a chocolate
 				Chocolate chocolate1 = chocolateRepository.cocoaGreaterThan(60).get(0);  // getting  a chocolate with cocoagreater than 60 from repository, get 0 to get whatever first item in that list is
				 System.out.println(chocolate1);

		assertAll(" Should return a chocolate with the following properities",
				() -> assertEquals("Name4", chocolate1.getName()),
				() -> assertEquals(100, chocolate1.getCocoaPercentage()),
		    	() -> assertEquals("US_Estate",chocolate1.getEstate().getName()));






	}


}
