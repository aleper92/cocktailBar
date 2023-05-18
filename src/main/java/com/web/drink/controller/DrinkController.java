package com.web.drink.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.drink.dto.DrinkDto;
import com.web.drink.service.DrinkService;

@RestController
@RequestMapping("/drink")
public class DrinkController {
	
	private static final Logger logger = LoggerFactory.getLogger(DrinkController.class);

	@Autowired
	DrinkService drinkService;
	
	@GetMapping("/{id}")
	public ResponseEntity<DrinkDto> searchDrinkById(@PathVariable("id") long id) throws IllegalAccessException, InvocationTargetException {
		logger.info("REST request to find drink by id", id);
		DrinkDto drinkDto = drinkService.findByIdDrink(id);
		return ResponseEntity.ok(drinkDto);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<DrinkDto>> searchDrink(@RequestParam(name = "name") String name) {
		logger.info("REST request search drink", name);
		List<DrinkDto> drinkDto = drinkService.searchDrink(name);
		return ResponseEntity.ok(drinkDto);
	}
	
	@GetMapping("/search/ingredient/{idIngredient}")
	public ResponseEntity<List<DrinkDto>> searchDrinkByIdIngredient(@PathVariable("idIngredient") long idIngredient) throws IllegalAccessException, InvocationTargetException {
		logger.info("REST request to find drink by idIngredient", idIngredient);
		List<DrinkDto> drinkDto = drinkService.findByIdIngredient(idIngredient);
		return ResponseEntity.ok(drinkDto);
	}
}
