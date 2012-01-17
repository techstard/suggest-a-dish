package org.vj.cook.bo;

import java.util.Date;

/**
 * This is the main business entity in cooking suggestion software.
 * This will hold the name of the Recipe and last suggested time and last preparation time.
 * @author vijay_dharap
 *
 */
public class Recipe {
	
	private Integer id;
	
	/**
	 * The name of the recipe
	 */
	private String name;
	/**
	 * Date last this recipe was suggested to client
	 */
	private Date lastSuggestedDt;
	/**
	 * Last time client reported that the recipe was made.
	 */
	private Date lastPreparedDt;
	
	
	/**
	 * For reflection based frameworks to work
	 */
	public Recipe() {
	}
	
	public Recipe(String name) {
		this.name = name;
	}
	
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getLastSuggestedDt() {
		return lastSuggestedDt;
	}
	public void setLastSuggestedDt(Date lastSuggestedDt) {
		this.lastSuggestedDt = lastSuggestedDt;
	}
	public Date getLastPreparedDt() {
		return lastPreparedDt;
	}
	public void setLastPreparedDt(Date lastPreparedDt) {
		this.lastPreparedDt = lastPreparedDt;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
