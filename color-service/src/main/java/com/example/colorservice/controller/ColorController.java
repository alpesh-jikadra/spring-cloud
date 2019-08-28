package com.example.colorservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ColorController {
	
	@Value("${color:#ff0000}")
	private String color;
	
	@GetMapping("/getColor")
	public String getColor(){
		return color;
	}
}
