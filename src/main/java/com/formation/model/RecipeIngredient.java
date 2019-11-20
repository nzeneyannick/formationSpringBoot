package com.formation.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
public class RecipeIngredient {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	private Ingredient ingredient;
	@Column
	private Long quantity;
	@Column
	private String unit;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeIngredient that = (RecipeIngredient) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(ingredient, that.ingredient) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredient, quantity, unit);
    }

	
	 @Override
	    public String toString() {
	        return ToStringBuilder.reflectionToString(this);
	    }
	
	

}
