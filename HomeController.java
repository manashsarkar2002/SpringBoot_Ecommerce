package com.example.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
@GetMapping("/")
public String index()
{
		return "index";
}
@GetMapping("/nav")
public String navBar()
{
	return "navbar";
}
@GetMapping("/reg")
public String register()
{
	return "signup";
}

@GetMapping("/log")
public String login()
{
	return "login";
}

@GetMapping("/dash")
public String dashboard()
{
	return "dashboard";
}

@GetMapping("/addprod")
public String addProduct()
{
	return "addProduct";
}
}
