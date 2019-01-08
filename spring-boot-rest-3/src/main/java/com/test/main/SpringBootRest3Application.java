package com.test.main;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.main.model.Vehicle;

@SpringBootApplication
public class SpringBootRest3Application {

	@Autowired
	private  Vehicle  v ;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRest3Application.class, args);
		
	}

	public void color() {
		System.out.println(v.color());
	}
	
	@PostConstruct
    public void init() {
        System.out.println("Calling starter.init");
        System.out.println(v.color());
        
    }
}

