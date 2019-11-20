package com.formation.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.model.Recipe;

@Repository
@Transactional
public class RecipeRepository {
	private final EntityManager entityManager;

	public RecipeRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Recipe> getAllRecipe() {
		List<Recipe> listRecipe = new ArrayList<>();
		try {
			Session session = entityManager.unwrap(Session.class);
			@SuppressWarnings("unchecked")
			Query<Recipe> query = session.createQuery("from Recipe");
			listRecipe = query.list();
		} catch (HibernateException h) {
			h.printStackTrace();
		}
		return listRecipe;
	}

	public Recipe getRecipeById(Long id) {
		List<Recipe> listRecipe = new ArrayList<>();
		try {
			Session session = entityManager.unwrap(Session.class);
			@SuppressWarnings("unchecked")
			Query<Recipe> query = session.createQuery("FROM Recipe where id = :id");
			query.setParameter("id", id);
			listRecipe = query.list();

		} catch (HibernateException h) {
			h.printStackTrace();
		}
		return listRecipe != null ? listRecipe.get(0) : null;
	}
	
	public void createRecipe(Recipe recipe) {

		try {
			Session session = entityManager.unwrap(Session.class);;
			session.save(recipe);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public  void deleteRecipeById(Long id) {
		try {
			Session session = entityManager.unwrap(Session.class);
			Query<Recipe> query = session.createQuery("DELETE FROM Recipe WHERE  id =:id");
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (HibernateException e) {
			e.printStackTrace();
		}		
		
	}
	
	public void updateRecipe(Long id, Recipe recipe) {
		try {
			Session session = entityManager.unwrap(Session.class);
	
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}
	
	

}
