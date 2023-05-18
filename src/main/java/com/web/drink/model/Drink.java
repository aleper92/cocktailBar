package com.web.drink.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "drink")
@Getter
@Setter
@NoArgsConstructor
public class Drink implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description", columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "alcoholic")
	private Boolean alcoholic;
	
	@ManyToOne
	@JoinColumn(name = "id_glass", referencedColumnName = "id")
	private Glass glass;
	
	@OneToMany(mappedBy = "drink")
	private List<ImageDrink> imageDrink;
	
	@OneToMany(mappedBy = "drink")
	private List<DrinkIngredient> drinkIngredient;
}
