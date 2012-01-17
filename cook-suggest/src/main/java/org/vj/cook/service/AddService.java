package org.vj.cook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.vj.cook.bo.Recipe;
import org.vj.cook.dao.RecipeMapper;

/**
 * Service class to add the recipes to database
 * @author vijay_dharap
 *
 */
@Service
public class AddService implements IAddService{
	@Autowired
	private RecipeMapper recipeMapper;
	
	public void setRecipeMapper(RecipeMapper recipeMapper) {
		this.recipeMapper = recipeMapper;
	}

	/* (non-Javadoc)
	 * @see org.vj.cook.service.IAddService#addRecipe(org.vj.cook.Recipe)
	 */
	@Override
	@Transactional
	public void addRecipe(Recipe recipe) {
		this.recipeMapper.insertOrUpdate(recipe);
	}

}
