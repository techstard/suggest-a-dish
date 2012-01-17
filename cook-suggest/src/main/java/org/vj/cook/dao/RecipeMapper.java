package org.vj.cook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.vj.cook.bo.Recipe;

/**
 * Utility class to populate the DB
 * @author vijay_dharap
 *
 */
public interface RecipeMapper {

	/**
	 * Quick and dirty way to add new recipes
	 * @param recipe
	 * @return id of inserted row.
	 */
	@Insert("insert into cooking.recipe(name, lastSuggestedDate, lastPreparedDate) " +
			"values(#{name},sysdate,sysdate)")
	public int add(Recipe recipe);

	@Insert("merge into cooking.recipe(name, lastSuggestedDate, lastPreparedDate) " +
			"KEY(NAME)" +
			"values(#{name},sysdate,sysdate)")
	public int insertOrUpdate(Recipe recipe);

	@Select("select * from cooking.recipe")
	public List<Recipe> suggest();
}
