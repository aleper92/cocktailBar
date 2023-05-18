package com.web.drink.mapper;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.web.drink.dto.IngredientDto;
import com.web.drink.model.Ingredient;

@Component
public class IngredientMapper {

	public IngredientDto toDto(Ingredient ingredient) {
		IngredientDto ingredientDto = new IngredientDto();
		
		ingredientDto.setId(ingredient.getId());
		ingredientDto.setName(ingredient.getName());
		
		return ingredientDto;
	}
	
	public List<IngredientDto> toDtoList(List<Ingredient> ingredient) {
		List<IngredientDto> ingredientDto = new ArrayList<>();
		
		for(Ingredient NIngredient: ingredient) {
			IngredientDto dto = toDto(NIngredient);
			ingredientDto.add(dto);
		}
		
		return ingredientDto;
	}
}
