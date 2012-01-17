package org.vj.cook.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.vj.cook.bo.Recipe;
import org.vj.cook.service.AddService;

@ContextConfiguration(locations = { "classpath:org/vj/cook/config/applicationContext.xml" })
public class AddRecipeTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private AddService addService;
	
	public void setAddService(AddService addService) {
		this.addService = addService;
	}

	@Before
	public void setup(){
	}

	@Test
	@Rollback(true)
	public final void testFooService() {
		this.addService.addRecipe(new Recipe("Poli"));
		this.addService.addRecipe(new Recipe("Paneer Mutter"));
		this.addService.addRecipe(new Recipe("Matki Usal"));
		this.addService.addRecipe(new Recipe("बटाटेवडे"));
		this.addService.addRecipe(new Recipe("फरसबीची भाजी"));
		this.addService.addRecipe(new Recipe("पालकाची पातळभाजी"));
		this.addService.addRecipe(new Recipe("निवगर्‍या"));
		this.addService.addRecipe(new Recipe("घावन"));
		this.addService.addRecipe(new Recipe("घावन - Bhajani"));
		this.addService.addRecipe(new Recipe("तांदूळाची भाकरी"));
	}
}