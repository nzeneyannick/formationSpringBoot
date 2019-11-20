package com.formation.mapper;

import org.springframework.stereotype.Component;

import com.formation.dto.RecipeDto;
import com.formation.model.Recipe;
@Component
public class RecipeMapper {
	
	public RecipeDto convertToRecipeDto(Recipe recipe) {
		RecipeDto recipeDto = new RecipeDto();
		recipeDto.setId(recipe.getId());
		recipeDto.setName(recipe.getName());
		recipeDto.setDescription(recipe.getDescription());
		recipeDto.setIngredients(recipe.getIngredients());
		recipeDto.setInstructions(recipe.getInstructions());		
		return recipeDto;	
	}

	public Recipe convertToRecipe(RecipeDto recipeDto) {
		Recipe recipe = new Recipe();
		recipe.setId(recipeDto.getId());
		recipe.setName(recipeDto.getName());
		recipe.setDescription(recipeDto.getDescription());
		recipe.setIngredients(recipeDto.getIngredients());
		recipe.setInstructions(recipeDto.getInstructions());		
		return recipe;
	}
}
