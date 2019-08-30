package com.example.clientservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ColorServiceHandler {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Autowired
	private RestTemplate rest;
	
	@HystrixCommand(fallbackMethod="getDefault")
	public String getColor(){
		return this.rest.getForObject("http://color-service/getColor", String.class);
	}
	
	@HystrixCommand(fallbackMethod="getDefault")
	public String getFont(){
		return this.rest.getForObject("http://font-service/getColor", String.class);
	}
	public String getDefault() {
		return "#efefef";
	}
}
