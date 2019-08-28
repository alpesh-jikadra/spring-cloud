package com.example.clientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class GreetingController {
	
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate rest;

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
		model.addAttribute("name", name);
		String color= this.rest.getForObject("http://color-service/getColor", String.class);
		model.addAttribute("color", color);
		return "greeting";
	}
	
	@GetMapping("/greeting1")
	public String greeting1(){
		String color= this.rest.getForObject("http://color-service/getColor", String.class);
		return color;
	}
}
