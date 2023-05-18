package com.web.drink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.drink.model.Glass;

@Repository("glassRepository")
public interface GlassRepository extends JpaRepository<Glass, Long> 
{

}
