package com.formation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.formation.dto.RecipeDto;
import com.formation.model.Recipe;
import com.formation.repository.RecipeRepository;

@Service
public class RecipeService {
	private RecipeRepository recipeRepository;

	public RecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
	
	public List<RecipeDto> getAllRecipe(){
		List<Recipe> listRecipe = recipeRepository.getAllRecipe();
		List<RecipeDto> listRecipeDto = new ArrayList<>();
		for(Recipe recipe : listRecipe) {
			listRecipeDto.add(arg0);
		}
		
		
	} 

}
