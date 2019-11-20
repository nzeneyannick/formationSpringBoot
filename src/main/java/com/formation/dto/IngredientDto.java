package com.formation.dto;

import java.util.Objects;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.formation.model.Ingredient;

public class IngredientDto {
	private Long id;
	private String name;

	public Ingredient convertToIngredient() {
		Ingredient ingredient = new Ingredient();
		ingredient.setId(this.id);
		ingredient.setName(this.name);
		return ingredient;
	}


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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		IngredientDto that = (IngredientDto) o;
		return Objects.equals(id, that.id) && Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
