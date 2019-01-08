package com.test.main.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Bike implements Vehicle {

	@Override
	public String run() {
		// TODO Auto-generated method stub
		return "Bike is Running";
	}

	@Override
	public String color() {
		// TODO Auto-generated method stub
		return "Bike color is BLACK";
	}
	
	
}
