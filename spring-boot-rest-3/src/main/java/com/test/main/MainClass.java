package com.test.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.main.model.Vehicle;

@Service
public class MainClass {

	@Autowired
	static Vehicle v ;
	
	public static void main(String[] args) {
		
		System.out.println(v.run());

	}

}
