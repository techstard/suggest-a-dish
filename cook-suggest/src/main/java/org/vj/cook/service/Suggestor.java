package org.vj.cook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vj.cook.bo.Recipe;
import org.vj.cook.dao.RecipeMapper;


/**
 * This class should provide the suggestions based on available data.
 * @author vijay_dharap
 *
 */
@Service
public class Suggestor {

	@Autowired
	private RecipeMapper recipeMapper;
	
	public void setRecipeMapper(RecipeMapper recipeMapper) {
		this.recipeMapper = recipeMapper;
	}

	/**
	 * SuggestWindow should be calling this method to get suggestions
	 * @return
	 */
	public List<Recipe> suggest(){
//		throw new UnsupportedOperationException("Suggestions are yet to work!!");
		return recipeMapper.suggest();
	}
	
}
