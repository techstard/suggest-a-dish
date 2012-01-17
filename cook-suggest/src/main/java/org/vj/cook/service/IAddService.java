package org.vj.cook.service;

import org.springframework.transaction.annotation.Transactional;
import org.vj.cook.bo.Recipe;

public interface IAddService {
	
	/**
	 * Method to add the recipe to database
	 * @param recipe
	 */
	public void addRecipe(Recipe recipe);
}
