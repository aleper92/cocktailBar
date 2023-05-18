package com.web.drink.modelRedis;


import org.springframework.data.redis.core.RedisHash;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@RedisHash("Drink")
@Getter
@Setter
@NoArgsConstructor
public class DrinkRedis {

	private String id;
	private String name;
	private String description;
	private String alcoholic;
	//private Glass glass;

}
