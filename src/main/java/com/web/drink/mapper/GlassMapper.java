package com.web.drink.mapper;

import org.springframework.stereotype.Component;

import com.web.drink.dto.GlassDto;
import com.web.drink.model.Glass;

@Component
public class GlassMapper {

	public GlassDto toDto(Glass glass) {
		GlassDto glassDto = new GlassDto();
		
		glassDto.setId(glass.getId());
		glassDto.setType(glass.getType());
		
		return glassDto;
	}
}
