package com.web.drink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;



@SpringBootApplication
@EnableJpaAuditing
@EnableRedisRepositories
@EnableCaching
//@EnableSwagger2
public class CocktailBarApplication {

	public static void main(String[] args) {
		SpringApplication.run(CocktailBarApplication.class, args);
	}

}
