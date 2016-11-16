package org.elevenfifty.java301.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.elevenfifty.java301.beans.Product;
import org.elevenfifty.java301.repository.CustomerRepository;
import org.elevenfifty.java301.repository.ProductRepository;
//import org.elevenfifty.java301.repository.TransactionRepository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class IndexController {

	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	
//	@Autowired
//	private TransactionRepository transactionRepo;


	
	@GetMapping("")
	public String index(Model model){
		return "home";
	}

	
	//	@GetMapping(path = { "/home", "", "/" } )
//	public String home(Model model) {
//		
//		model.addAttribute("products", productRepo.findAll());
//
//		return "home";
//	}
	//You made "home" and "users" as your default page. You can't have two default pages for it to go to.
	//The computer won't make this decision for you, but it will try and eventually break.
	//Start using this "localhost:8080/h2-console".
	//This is what I took out of the HTTP path for your users get mapping.......path = { "/users", "", "/" }.......
	//Notice that the get mapping above has almost the same thing.
	
//		
//
//		@GetMapping("/employee")
//		public String employee(Model model) {
//			return "employee";
//		}
}
