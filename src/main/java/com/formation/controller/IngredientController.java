package com.formation.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
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
	private static final Logger logger =  LoggerFactory.getLogger(IngredientController.class);

	public IngredientController(IngredientService ingredientService) {

		this.ingredientService = ingredientService;
	}

	@GetMapping()
	public ResponseEntity<List<IngredientDto>> getAllIngredients() {
		logger.debug("debut fonction getMapping");
		return ResponseEntity.ok(ingredientService.getAllIngredient());


	}

	@PostMapping()
	public ResponseEntity<?> createComputer(IngredientDto ingredientDto) {
		logger.debug("createComputer ingredientDto = {} ",ingredientDto );
		ingredientService.createIngredient(ingredientDto);
		//a retouner un response entity ok cad code 200 lorsaue tout c'est bien passé en cas d'erreur le traiter
		//avec un controller advice qui retournera un response entity badrequest, y ajouter une classe apierror
		return ResponseEntity.ok(ingredientDto);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getIngredientById(@PathVariable ("id") Long id) {
		logger.debug("getIngredientById id = {}",id );
		return ResponseEntity.ok(ingredientService.getIngredientById(id));
		
	}
	@DeleteMapping("/{id}")
	public void deleteIngredientById(@PathVariable("id") Long id) {
		logger.debug("deleteIngredientById id = {}");
		ingredientService.deleteIngredientById(id);
	}

}
