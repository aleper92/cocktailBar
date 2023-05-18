package com.web.drink.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DrinkIngredientDto {

	private DrinkDto drinkDto;
	private IngredientDto ingredientDto;
	
}
