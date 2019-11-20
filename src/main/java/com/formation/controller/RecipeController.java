package com.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.dto.RecipeDto;
import com.formation.service.RecipeService;

@RestController
@RequestMapping("/recipes")

public class RecipeController {
	@Autowired
	private  RecipeService recipeService;
	
		
	@GetMapping()
	public List<RecipeDto> getAllRecipes(){
		return this.recipeService.getAllRecipe();
		
	}
	@GetMapping("/{id}")
	public RecipeDto getRecipeById(@PathVariable("id") Long id) {
		return this.recipeService.getRecipeById(id);
		
	}
	@PostMapping()
	public void createRecipe(RecipeDto recipeDto) {
		this.recipeService.createRecipe(recipeDto);		
	}
	@DeleteMapping("/{id}")
	public void deleteRecipe(Long id){
		this.recipeService.deleteRecipeById(id);
		
	}

}
