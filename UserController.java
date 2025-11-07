package com.example.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jpa.model.User;
import com.example.jpa.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
@Autowired
UserRepository ur;
@PostMapping("/regproc")
public String addUser(@RequestParam("name")String name,@RequestParam("email")String email,
		@RequestParam("phone")String phno,@RequestParam("password")String pass,ModelMap model)
{
	User user=new User();
	user.setName(name);
	user.setEmail(email);
	user.setPhno(Long.parseLong(phno));
	user.setPassword(pass);
	user.setRole("customer");
	ur.save(user);
	model.put("msg", "Registered Successfully!");
	return "signup";
}
@PostMapping("/logproc")
public String logProcess(@RequestParam("email")String email,@RequestParam("password")String pass,
		HttpSession session,ModelMap model)
{
	User user=null;
	user=ur.findByEmailAndPassword(email, pass);
	if(user!=null)
	{
		String role=user.getRole();
		if(role.equals("customer"))
		{
			session.setAttribute("udata", email);
			return "index";
		}else {
			return "redirect:/viewData";
		}
	}else {
		model.put("msg", "Wrong credential plz check!");
		return "login";
	}
}
@RequestMapping("/logout")
public String destroy(HttpServletRequest request)
{
	request.getSession().invalidate();
	return "index";
}
}
