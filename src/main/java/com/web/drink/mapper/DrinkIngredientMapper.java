package com.web.drink.mapper;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.web.drink.dto.DrinkIngredientDto;
import com.web.drink.model.DrinkIngredient;

@Component
public class DrinkIngredientMapper {

	public DrinkIngredientDto toDto(DrinkIngredient drinkIngredient) {
		DrinkIngredientDto drinkIngredientDto = new DrinkIngredientDto();
		DrinkMapper drink = new DrinkMapper();
		IngredientMapper ingredient = new IngredientMapper();
		
		drinkIngredientDto.setDrinkDto(drink.toDto(drinkIngredient.getDrink()));
		drinkIngredientDto.setIngredientDto(ingredient.toDto(drinkIngredient.getIngredient()));
		
		return drinkIngredientDto;
	}
	
	public List<DrinkIngredientDto> toDtoList(List<DrinkIngredient> drinkIngredient) {
		List<DrinkIngredientDto> drinkIngredientDto = new ArrayList<>();
		
		for(DrinkIngredient drinkIng: drinkIngredient) {
			DrinkIngredientDto dto = toDto(drinkIng);
			drinkIngredientDto.add(dto);
		}
		
		return drinkIngredientDto;
	}
}
