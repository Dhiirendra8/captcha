package com.test.main.model;

import org.springframework.stereotype.Component;

@Component

public class Car implements Vehicle {

	@Override
	public String run() {
		// TODO Auto-generated method stub
		return "Car is Running";
	}

	@Override
	public String color() {
		// TODO Auto-generated method stub
		return "Car color is RED";
	}
	
	
}
