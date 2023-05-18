package com.web.drink.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.drink.modelRedis.DrinkRedis;

@Repository
public interface DrinkRedisRepository extends CrudRepository<DrinkRedis, String> {

}
