package com.formation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dto.RecipeDto;
import com.formation.mapper.RecipeMapper;
import com.formation.model.Recipe;
import com.formation.repository.RecipeRepository;

@Service
public class RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;
	@Autowired
	private RecipeMapper recipeMapper;

	public List<RecipeDto> getAllRecipe() {
		List<Recipe> listRecipe = recipeRepository.getAllRecipe();
		List<RecipeDto> listRecipeDto = new ArrayList<>();
		for (Recipe recipe : listRecipe) {
			listRecipeDto.add(recipeMapper.convertToRecipeDto(recipe));
		}
		return listRecipeDto;

	}

	public RecipeDto getRecipeById(Long id) {
		Recipe recipe = recipeRepository.getRecipeById(id);
		RecipeDto recipeDto = recipeMapper.convertToRecipeDto(recipe);
		return recipeDto;

	}

	public void createRecipe(RecipeDto recipeDto) {
		Recipe recipe = recipeMapper.convertToRecipe(recipeDto);

		this.recipeRepository.createRecipe(recipe);
	}

	public void deleteRecipeById(Long id) {
		this.recipeRepository.deleteRecipeById(id);
	}

}
