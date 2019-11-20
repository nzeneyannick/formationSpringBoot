package com.formation.mapper;

import org.springframework.stereotype.Component;

import com.formation.dto.IngredientDto;
import com.formation.model.Ingredient;
@Component
public class IngredientMapper {

	public IngredientDto convertToIngredientDto(Ingredient ingredient) {
		IngredientDto dto = new IngredientDto();
		dto.setId(ingredient.getId());
		dto.setName(ingredient.getName());
		return dto;
		
	}
	
	public Ingredient convertToIngredient(IngredientDto ingredient) {
		Ingredient ing = new Ingredient();
		ing.setId(ingredient.getId());
		ing.setName(ingredient.getName());
		return ing;
		
	}
	

}
