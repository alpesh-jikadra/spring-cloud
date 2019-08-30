package com.example.clientservice.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.clientservice.service.ColorServiceHandler;

@Controller
public class GreetingController {
	private static final Logger LOG = Logger.getLogger(GreetingController.class.getName());
	@Autowired
	private ColorServiceHandler handler;
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
		LOG.info("start of greeting");
		model.addAttribute("name", name);
		model.addAttribute("color", handler.getColor());
		return "greeting";
	}
	@GetMapping("/")
	public String health() {
		return "OK!";
	}
	
}
