package com.formation.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.model.Ingredient;
@Repository
@Transactional
public class IngredientRepository {
	private final EntityManager entityManager;
	

	public IngredientRepository(EntityManager entityManager) {
		this.entityManager=entityManager;
	}

	

	public List<Ingredient> getAllIngredient() {
		List<Ingredient> listIngredient = new ArrayList<>();
		try {
			Session session = entityManager.unwrap(Session.class);
			@SuppressWarnings("unchecked")
			Query<Ingredient> query = session.createQuery("from Ingredient");
			listIngredient = query.list();

		} catch (HibernateException h) {
			h.printStackTrace();
		}
		return listIngredient;
	}

	public Ingredient getIngredientById(Long id) {
		List<Ingredient> listIngredient = new ArrayList<>();
		try {
			Session session = entityManager.unwrap(Session.class);
			@SuppressWarnings("unchecked")
			Query<Ingredient> query = session.createQuery("FROM Ingredient where id = :id");
			query.setParameter("id", id);
			listIngredient = query.list();

		} catch (HibernateException h) {
			h.printStackTrace();
		}
		return listIngredient!=null?listIngredient.get(0):null;
	}

	public void createIngredient(Ingredient ingredient) {

		try {
			Session session = entityManager.unwrap(Session.class);;
			session.save(ingredient);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public void updateIngredient(Long id, Ingredient ingredient) {
		try {
			Session session = entityManager.unwrap(Session.class);
	
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		}

	}
	public  void deleteIngredientById(Long id) {
		try {
			Session session = entityManager.unwrap(Session.class);
			Query<Ingredient> query = session.createQuery("DELETE FROM Ingredient WHERE  id =:id");
			query.setParameter("id", id);
			query.executeUpdate();
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		
		
	}

}
