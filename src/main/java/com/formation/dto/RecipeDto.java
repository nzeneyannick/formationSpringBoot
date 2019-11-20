package com.formation.dto;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.formation.model.RecipeIngredient;

public class RecipeDto {
	private Long id;

	private String name;

	private String picture;

	private String description;
	private Set<RecipeIngredient> ingredients = new HashSet<>();

	private Set<String> instructions = new HashSet<>();
	 @Override
	    public String toString() {
	        return ToStringBuilder.reflectionToString(this);
	    }
}
