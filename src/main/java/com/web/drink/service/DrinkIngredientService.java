package com.web.drink.service;

import java.util.List;

import com.web.drink.dto.DrinkIngredientDto;

public interface DrinkIngredientService {

	public List<DrinkIngredientDto> findByIdIngredient(Long idIngredient);
	
}
