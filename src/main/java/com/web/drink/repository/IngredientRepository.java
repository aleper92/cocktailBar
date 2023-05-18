package com.web.drink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.drink.model.Ingredient;

@Repository("ingredientRepository")
public interface IngredientRepository extends JpaRepository<Ingredient, Long>
{

}
