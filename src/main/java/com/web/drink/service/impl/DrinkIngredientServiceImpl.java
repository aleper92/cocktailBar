package com.web.drink.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.drink.dto.DrinkIngredientDto;
import com.web.drink.mapper.DrinkIngredientMapper;
import com.web.drink.model.DrinkIngredient;
import com.web.drink.repository.DrinkIngredientRepository;
import com.web.drink.service.DrinkIngredientService;

@Service
public class DrinkIngredientServiceImpl implements DrinkIngredientService {
	
	private static final Logger logger = LoggerFactory.getLogger(DrinkIngredientServiceImpl.class);

	@Autowired
	DrinkIngredientRepository drinkIngredientRepository;

	@Autowired
	DrinkIngredientMapper drinkIngredientMapper;
	
	@Override
	public List<DrinkIngredientDto> findByIdIngredient(Long idIngredient) {
		logger.info("GetdrinkIngredientByIdIngredient", idIngredient);
		
		List<DrinkIngredient> drinkIngredient = drinkIngredientRepository.findByIdIngredient(idIngredient);
		List<DrinkIngredientDto> drinkIngredientDto = drinkIngredientMapper.toDtoList(drinkIngredient);
		
		return drinkIngredientDto;
	}
}
