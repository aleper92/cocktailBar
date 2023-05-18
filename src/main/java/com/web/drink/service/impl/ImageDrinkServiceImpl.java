package com.web.drink.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.drink.dto.ImageDrinkDto;
import com.web.drink.mapper.ImageDrinkMapper;
import com.web.drink.model.ImageDrink;
import com.web.drink.repository.ImageDrinkRepository;
import com.web.drink.service.ImageDrinkService;

@Service
public class ImageDrinkServiceImpl implements ImageDrinkService {

	private static final Logger logger = LoggerFactory.getLogger(ImageDrinkServiceImpl.class);

	@Autowired 
	ImageDrinkRepository imageDrinkRepository;
	
	@Autowired
	ImageDrinkMapper imageDrinkMapper;

	@Override
	public List<ImageDrinkDto> findImageByIdDrink(Long idDrink) {
		
		logger.info("GetImageByIdDrink", idDrink);

		List<ImageDrink> image = imageDrinkRepository.findImageByIdDrink(idDrink);
		
		List<ImageDrinkDto> imageDto = imageDrinkMapper.toDtoList(image);
		
		return imageDto;
	}
	
	
}
