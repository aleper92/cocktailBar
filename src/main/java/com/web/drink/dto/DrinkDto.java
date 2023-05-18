package com.web.drink.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class DrinkDto {

	private Long id;
	private String name;
	private String description;
	private boolean alcoholic;
	private GlassDto glassDto;
	
}
