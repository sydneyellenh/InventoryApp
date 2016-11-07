package org.elevenfifty.java301.controller;

import java.sql.SQLException;

import javax.validation.Valid;

import org.elevenfifty.java301.beans.Product;
import org.elevenfifty.java301.beans.User;
import org.elevenfifty.java301.repository.CustomerRepository;
import org.elevenfifty.java301.repository.ProductRepository;
import org.elevenfifty.java301.repository.TransactionRepository;
//import org.elevenfifty.java301.beans.UserImage;
//import org.elevenfifty.java301.repository.UserImageRepository;
import org.elevenfifty.java301.repository.UserRepository;
import org.robotsanddonuts.beans.Transaction;
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

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private TransactionRepository transactionRepo;
	
	@Autowired
	private CustomerRepository customerRepo;

//	@Autowired
//	private UserImageRepository userImageRepo;

//	@GetMapping("")
//	public String index(Model model) {
//
//		return "index";
//	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}

	@GetMapping(path = { "/home", "", "/" } )
	public String home(Model model) {

		model.addAttribute("users", userRepo.findAll());
		model.addAttribute("products", productRepo.findAll());

		return "home";
		
	}
	//You made "home" and "users" as your default page. You can't have two default pages for it to go to.
	//The computer won't make this decision for you, but it will try and eventually break.
	//Start using this "localhost:8080/h2-console".
	//This is what I took out of the HTTP path for your users get mapping.......path = { "/users", "", "/" }.......
	//Notice that the get mapping above has almost the same thing. 
	
	
//users
	@GetMapping("/users")
	public String users(Model model) {

		model.addAttribute("users", userRepo.findAll());

		return "users";
		
		
	}

	@GetMapping("/user/{id}")
	public String user(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);

		User u = userRepo.findOne(id);
		model.addAttribute("user", u);

//		 UserImage i = userImageRepo.findByUserId(id);
//		 model.addAttribute("userImage", i);

		return "user_detail";

	}

	@GetMapping("/user/{id}/edit")
	public String userEdit(Model model, @PathVariable(name = "id") long id) {
		model.addAttribute("id", id);

		User u = userRepo.findOne(id);
		model.addAttribute("user", u);
		return "user_edit";
	}

	@PostMapping("/user/{id}/edit")
	public String userEditSave(Model model, @PathVariable(name = "id") long id, @ModelAttribute @Valid User user,
			BindingResult result, @RequestParam("file") MultipartFile file,
			@RequestParam(name = "removeImage", defaultValue = "false", required = false) boolean removeImage) {

//		if (result.hasErrors()) {
//			return "user_edit";
//		} else {
//			if (removeImage) {
//				// See if the user has a user image
//				UserImage image = userImageRepo.findByUserId(id);
//
//				if (image == null) {
//					// Remove image if it exists
//					userImageRepo.delete(image);
//					log.info("Image removed" + id);
//				}
//			} else if (file != null && !file.isEmpty()) {
//
//				// Check to see if there is an uploaded file
//				try {
//					// Load the file into the proper format
//					// Load or create user image
//					UserImage image = userImageRepo.findByUserId(id);
//
//					if (image == null) {
//						image = new UserImage();
//						image.setUserId(id);
//					}
//
//					image.setContentType(file.getContentType());
//					image.setImage(file.getBytes());
//					userImageRepo.save(image);
//
//					// Store in the database
//				} catch (IOException e) {
//					log.error("Failed to upload file", e);
//
//				}
//			}

			userRepo.save(user);
			return "redirect:/user/" + user.getId();
		}
	
	
//products
	@GetMapping("/product/{productId}")
	public String product(Model model, @PathVariable(name = "productId") long productId) {
		model.addAttribute("productId", productId);

		Product p = productRepo.findOne(productId);
		model.addAttribute("product", p);


		return "product_detail";
	

	}
	
	@GetMapping("/product/{productId}/edit")
	public String productEdit(Model model, @PathVariable(name = "productId") long productId) {
		model.addAttribute("productId", productId);

		Product p = productRepo.findOne(productId);
		model.addAttribute("product", p);
		return "product_edit";
	}

	@PostMapping("/product/{productId}/edit")
	public String productEditSave(Model model, @PathVariable(name = "productId") long productId, 
			@ModelAttribute @Valid Product product,
			BindingResult result, @RequestParam("file") MultipartFile file) {


			productRepo.save(product);
			return "redirect:/product/" + product.getProductId();

		}
	
	@GetMapping("/product/create")
	public String productCreateSave(){
		return "product_create";
	}
	
	@PostMapping("/product/create")
    public String productCreateSave(@ModelAttribute @Valid Product product, Model model) {

        productRepo.save(product);
            return "redirect:/product/" + product.getProductId();
    }
	
	@GetMapping("/product/edit")
	public String productEditSave(){
		return "product_edit";
	}
	
	@PostMapping("/product/edit")
    public String productEditSave(@ModelAttribute @Valid Product product, Model model) {

        productRepo.delete(product);
            return "redirect:/home/" + product.getProductId();
    }
	
	@GetMapping("/products")
	public String products(Model model) {

		model.addAttribute("products", productRepo.findAll());

		return "products";
	}
	
	@GetMapping("/product/{productId}/delete")
	   public String productDelete(Model model, @PathVariable(name = "productId") long productId) {
	       model.addAttribute("productId", productId);
	       Product p = productRepo.findOne(productId);
	       model.addAttribute("product", p);
	       return "product_delete";
	   }

	   @PostMapping("/product/{productId}/delete")
	   public String productDeleteSave(@PathVariable(name = "productId") long productId, @ModelAttribute @Valid Product product,
	           BindingResult result, Model model) {
	       if (result.hasErrors()) {
	           model.addAttribute("product", product);
	           return "product_delete";
	       } else {
	           productRepo.delete(product);
	           return "redirect:/products";
	       }
	   }

	   
//transactions
		@GetMapping("/transactions")
		public String findAllTransactions(Model model) throws SQLException {
			model.addAttribute("transactions", transactionRepo.findAll());
			return "transaction/transactions";
		}
	   
		@GetMapping("/transaction/{id}/edit")
		public String transactionEdit(Model model, @PathVariable(name = "id") long id) {
			model.addAttribute("id", id);
			Transaction t = transactionRepo.findOne(id);
			model.addAttribute("transaction", t);
			model.addAttribute("customers", customerRepo.findAll());
			model.addAttribute("products", productRepo.findAll());
			return "transaction/transaction_edit";
		}
}
