package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jpa.model.Product;
import com.example.jpa.repository.ProductRepository;

@Controller
public class ProductController {
@Autowired
ProductRepository prepo;
@PostMapping("/insert")
public String addData(@RequestParam("prodid")String id,@RequestParam("prodname")String name,
		@RequestParam("category")String cat,@RequestParam("qty")String qty,
		@RequestParam("price")String price,ModelMap model)
{
	Product prod=new Product();
	prod.setId(id);
	prod.setName(name);
	prod.setCategory(cat);
	prod.setQuantity(Integer.parseInt(qty));
	prod.setPrice(Double.parseDouble(price));
	prepo.save(prod);
	model.put("msg", "Item Added!");
	return "addProduct";
	
}
@GetMapping("/viewData")
public String getAllData(Model model)
{
	List<Product> prod=prepo.findAll();
	model.addAttribute("data",prod);
	return "dashboard";
	
}
@GetMapping("/mens")
public String getAllMensItem(Model model)
{
	List<Product> prod=(List<Product>) prepo.findByCategory("mcollection");
	model.addAttribute("product",prod);
	return "mens";
}
@RequestMapping("/select/{id}")
public String getSelectProduct(@PathVariable String id, Model model)
{
	Product prod=prepo.findById(id).orElseThrow();
	model.addAttribute("product",prod);
	return "updateForm";
}

@RequestMapping("/del/{id}")
public String deleteProduct(@PathVariable String id)
{
	prepo.deleteById(id);
	return "redirect:/viewData";
}
@RequestMapping("/update")
public String updateRecord(@RequestParam("prodid")String id, @RequestParam("prodname")String name,
		@RequestParam("prodcat")String catagory,@RequestParam("qty")String quantity,
		@RequestParam("price")String price)

{
	//System.out.println("Hello........."+name);
	Product prod=new Product();
	prod.setId(id);
	prod.setName(name);
	prod.setCategory(catagory);
	prod.setQuantity(Integer.parseInt(quantity));
	prod.setPrice(Double.parseDouble(price));
	prepo.save(prod);
	return "redirect:/viewData";
}



}
