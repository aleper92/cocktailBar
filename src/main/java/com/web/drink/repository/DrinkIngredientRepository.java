package com.web.drink.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.drink.model.DrinkIngredient;

@Repository("DrinkIngredientRepository")
public interface DrinkIngredientRepository extends JpaRepository<DrinkIngredient, Long>
{
	@Query("SELECT d FROM DrinkIngredient d WHERE d.ingredient.id = :idIngredient")
	List<DrinkIngredient> findByIdIngredient(@Param("idIngredient") Long idIngredient);
}
