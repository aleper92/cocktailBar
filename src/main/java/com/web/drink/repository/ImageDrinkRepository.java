package com.web.drink.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.drink.model.ImageDrink;

@Repository("imageRepository")
public interface ImageDrinkRepository extends JpaRepository<ImageDrink, Long> 
{
	@Query("SELECT i FROM ImageDrink i WHERE i.drink.id = :idDrink")
	List<ImageDrink> findImageByIdDrink(@Param("idDrink") Long idDrink);
}
