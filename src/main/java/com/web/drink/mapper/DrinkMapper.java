package com.web.drink.mapper;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.web.drink.dto.DrinkDto;
import com.web.drink.model.Drink;
import com.web.drink.modelRedis.DrinkRedis;

@Component
public class DrinkMapper {

	public DrinkDto toDto(Drink drink) {
		DrinkDto drinkDto = new DrinkDto();
		GlassMapper glass = new GlassMapper();
		
		drinkDto.setId(drink.getId());
		drinkDto.setDescription(drink.getDescription());
		drinkDto.setName(drink.getName());
		drinkDto.setAlcoholic(drink.getAlcoholic());
		drinkDto.setGlassDto(glass.toDto(drink.getGlass()));
		
		return drinkDto;
		
	}
	
	public DrinkDto fromRedisToDto(DrinkRedis drink) {
		DrinkDto drinkDto = new DrinkDto();
		//GlassMapper glass = new GlassMapper();
		
		drinkDto.setId(Long.parseLong(drink.getId()));
		drinkDto.setDescription(drink.getDescription());
		drinkDto.setName(drink.getName());
		drinkDto.setAlcoholic(Boolean.parseBoolean(drink.getAlcoholic()));
		//drinkDto.setGlassDto(glass.toDto(drink.getGlass()));
		
		return drinkDto;
		
	}
	
	public List<DrinkDto> toDtoList(List<Drink> drink) {
		List<DrinkDto> drinkDto = new ArrayList<>();
		
		for(Drink NDrink: drink) {
			DrinkDto dto = toDto(NDrink);
			drinkDto.add(dto);
		}
		
		return drinkDto;
	}
}
