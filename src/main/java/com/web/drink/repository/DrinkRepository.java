package com.web.drink.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.drink.model.Drink;

@Repository("drinkRepository")
public interface DrinkRepository extends JpaRepository<Drink, Long>
{
	@Query("Select d FROM Drink d WHERE name LIKE :name%")
	List<Drink> findByName(@Param("name") String name);
}
