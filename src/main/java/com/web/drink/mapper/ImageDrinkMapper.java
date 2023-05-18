package com.web.drink.mapper;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.web.drink.dto.ImageDrinkDto;
import com.web.drink.model.ImageDrink;

@Component
public class ImageDrinkMapper {

	public ImageDrinkDto toDto(ImageDrink imageDrink) {
		ImageDrinkDto imageDrinkDto = new ImageDrinkDto();
		//DrinkMapper drink = new DrinkMapper();
		
		imageDrinkDto.setImage(imageDrink.getImage());
		//imageDrinkDto.setDrinkDto(drink.toDto(imageDrink.getDrink()));
		
		return imageDrinkDto;
	}
	
	public List<ImageDrinkDto> toDtoList(List<ImageDrink> imageDrink) {
		List<ImageDrinkDto> imageDrinkDto = new ArrayList<>();
		
		for(ImageDrink NImage: imageDrink) {
			ImageDrinkDto dto = toDto(NImage);
			imageDrinkDto.add(dto);
		}
		
		return imageDrinkDto;
	}
}
