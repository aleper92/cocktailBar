package com.web.drink.service.impl;

import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.drink.dto.DrinkDto;
import com.web.drink.handler.NotFoundException;
import com.web.drink.mapper.DrinkIngredientMapper;
import com.web.drink.mapper.DrinkMapper;
import com.web.drink.model.Drink;
import com.web.drink.modelRedis.DrinkRedis;
import com.web.drink.repository.DrinkRedisRepository;
import com.web.drink.repository.DrinkRepository;
import com.web.drink.service.DrinkIngredientService;
import com.web.drink.service.DrinkService;
import org.apache.commons.beanutils.BeanUtils;

import com.web.drink.dto.DrinkIngredientDto;

@Service
public class DrinkServiceImpl implements DrinkService{

	private static final Logger logger = LoggerFactory.getLogger(DrinkServiceImpl.class);
	
	@Autowired
	DrinkRepository drinkRepository;
	
	@Autowired
	DrinkIngredientService drinkIngredientService;
	
	@Autowired
	DrinkMapper drinkMapper;
	
	@Autowired
	DrinkIngredientMapper drinkIngredientMapper;
	
	@Autowired
	DrinkRedisRepository drinkRedisRepository;
	

	@Override
	public List<DrinkDto> searchDrink(String name) {
		logger.info("Search drink", name);

		List<Drink> drink = drinkRepository.findByName(name);
		List<DrinkDto> drinkDto = drinkMapper.toDtoList(drink);
		
		return drinkDto;
	}

	/*
	@Override
	public DrinkDto findByIdDrink(Long id) {
		logger.info("GetIdDrink", id);
		
		Optional<Drink> drink = Optional.ofNullable(drinkRepository.findById(id).orElseThrow(() -> new NotFoundException("Drink not found")));
		Drink cocktail = drink.get();
		DrinkDto drinkDto = drinkMapper.toDto(cocktail);
		
		return drinkDto;
	}
	*/
	

	@Override
	public DrinkDto findByIdDrink(Long id) throws IllegalAccessException, InvocationTargetException {
		logger.info("GetIdDrink", id);
		
		DrinkDto result = new DrinkDto();
		Optional<DrinkRedis> retrievedDrinkRedis = drinkRedisRepository.findById(id.toString());
		
		if (!retrievedDrinkRedis.isEmpty()) {
			logger.info("recuperato dalla cache", id);
			result = drinkMapper.fromRedisToDto(retrievedDrinkRedis.get());
		} else {
			logger.info("recuperato da db", id);
			Optional<Drink> drink = Optional.ofNullable(drinkRepository.findById(id).orElseThrow(() -> new NotFoundException("Drink not found")));
			Drink cocktail = drink.get();
			result = drinkMapper.toDto(cocktail);
			DrinkRedis fromEntity = new DrinkRedis();
			BeanUtils.copyProperties(fromEntity, cocktail);
			drinkRedisRepository.save(fromEntity);
		}
		
		return result;
	}
	

	@Override
	public List<DrinkDto> findByIdIngredient(Long idIngredient) throws IllegalAccessException, InvocationTargetException {
		logger.info("Get drink by id ingredient", idIngredient);
		
		List<DrinkIngredientDto> drinkIngredientDto = drinkIngredientService.findByIdIngredient(idIngredient);
		List<DrinkDto> listDrinkDto = new ArrayList<>();
		for(DrinkIngredientDto dto: drinkIngredientDto) {
			Long idDrink = dto.getDrinkDto().getId();
			DrinkDto drinkDto = findByIdDrink(idDrink);
			listDrinkDto.add(drinkDto);
		}
		
		return listDrinkDto;
	}

}
