package com.self.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}

	@RequestMapping("/{page}")
	public String page(@PathVariable String page){
		return page;
	}
	
	@RequestMapping("/get")
	public String load(String redirect){
		System.out.println(redirect);
		return redirect;
	}
}
