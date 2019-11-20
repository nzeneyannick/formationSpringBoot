package com.formation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.formation.dto.IngredientDto;
import com.formation.service.IngredientService;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

	private final IngredientService ingredientService;

	public IngredientController(IngredientService ingredientService) {

		this.ingredientService = ingredientService;
	}

	@GetMapping()
	public List<IngredientDto> getAllIngredients() {
		return ingredientService.getAllIngredient();

	}

	@PostMapping()
	public void createComputer(IngredientDto ingredientDto) {
		ingredientService.createIngredient(ingredientDto);
	}
	@GetMapping("/{id}")
	public IngredientDto getIngredientById(@PathVariable ("id") Long id) {
		return ingredientService.getIngredientById(id);		
		
	}
	@DeleteMapping("/{id}")
	public void deleteIngredientById(@PathVariable("id") Long id) {
		ingredientService.deleteIngredientById(id);
	}

}
