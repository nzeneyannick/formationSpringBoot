package com.formation.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String picture;
	@Column
	private String description;
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private Set<RecipeIngredient> ingredients = new HashSet<>();
	@ElementCollection(fetch = FetchType.EAGER)
	@Column
	private Set<String> instructions = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<String> getInstructions() {
		return instructions;
	}

	public void setInstructions(Set<String> instructions) {
		this.instructions = instructions;
	}
	

	public Set<RecipeIngredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<RecipeIngredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, picture, description, ingredients, instructions);
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Recipe recipe = (Recipe) o;
		return Objects.equals(id, recipe.id) && Objects.equals(name, recipe.name)
				&& Objects.equals(picture, recipe.picture) && Objects.equals(description, recipe.description)
				&& Objects.equals(ingredients, recipe.ingredients) && Objects.equals(instructions, recipe.instructions);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
