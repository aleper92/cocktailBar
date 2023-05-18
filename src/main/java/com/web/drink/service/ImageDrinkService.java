package com.web.drink.service;

import java.util.List;

import com.web.drink.dto.ImageDrinkDto;

public interface ImageDrinkService {

	public List<ImageDrinkDto> findImageByIdDrink(Long idDrink);
}
