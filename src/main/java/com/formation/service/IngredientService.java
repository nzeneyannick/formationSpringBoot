package com.formation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.dto.IngredientDto;
import com.formation.mapper.IngredientMapper;
import com.formation.model.Ingredient;
import com.formation.repository.IngredientRepository;

@Service
public class IngredientService {
	@Autowired
	private IngredientRepository ingredientRepository;
	@Autowired
	private IngredientMapper ingredientMapper;

	public List<IngredientDto> getAllIngredient() {
		List<Ingredient> listIngredient = ingredientRepository.getAllIngredient();
		List<IngredientDto> listIngredientDto = new ArrayList<>();
		for (Ingredient ing : listIngredient) {
			listIngredientDto.add(ingredientMapper.convertToIngredientDto(ing));
		}

		return listIngredientDto;

	}

	public void createIngredient(IngredientDto ingredientDto) {
		Ingredient ingredient = ingredientMapper.convertToIngredient(ingredientDto);
		ingredientRepository.createIngredient(ingredient);
	}

	public IngredientDto getIngredientById(Long id) {

		Ingredient ingredient = ingredientRepository.getIngredientById(id);
		IngredientDto ingredientDto = ingredientMapper.convertToIngredientDto(ingredient);
		return ingredientDto;

	}
	
	public void deleteIngredientById(Long id) {
		ingredientRepository.deleteIngredientById(id);
	}
	

}
