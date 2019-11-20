package com.formation.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.formation.model.Recipe;

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
	

}
