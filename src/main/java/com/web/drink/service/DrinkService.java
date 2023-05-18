package com.web.drink.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.web.drink.dto.DrinkDto;

public interface DrinkService {

	public List<DrinkDto> searchDrink(String name);
	
	public DrinkDto findByIdDrink(Long id) throws IllegalAccessException, InvocationTargetException;
	
	public List<DrinkDto> findByIdIngredient(Long idIngredient) throws IllegalAccessException, InvocationTargetException ;
}
