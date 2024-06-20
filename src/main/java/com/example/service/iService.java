package com.example.service;

import java.util.List;

public interface iService<T> {
	
	/** 
	 * @return List of all entities in the database.
	 */
	List<T> listEntity();
	
	/** 
	 * @param t Represents the entity to find in the database.
	 * @return The found entity, or null if not found.
	 */
	T findEntity(T t);
	
	/** 
	 * Saves or updates an entity.
	 * @param t The entity to save or update.
	 */
	void saveEntity(T t);
	
	/** 
	 * Deletes an entity.
	 * @param t The entity to delete.
	 */
	void deleteEntity(T t);

}
