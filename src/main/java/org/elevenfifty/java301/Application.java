package org.elevenfifty.java301;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;

import org.elevenfifty.java301.beans.User;
import org.elevenfifty.java301.sandwich.Ingredient;
import org.elevenfifty.java301.sandwich.Sandwich;
import org.elevenfifty.java301.sandwich.Sandwich.BreadType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	public static void oldMain(String[] args) {

		ConfigurableApplicationContext context = new SpringApplicationBuilder().sources(Application.class).run(args);

		System.out.println("--------------------------------------------");

		// Code here

		Sandwich sandwich = new Sandwich(BreadType.WHEAT);
		sandwich.addIngredient(context.getBean("turkey", Ingredient.class));
		sandwich.addIngredient(context.getBean("ham", Ingredient.class));
		sandwich.addIngredient(context.getBean("cheddar", Ingredient.class));
		sandwich.addIngredient(context.getBean("sweetOnion", Ingredient.class));

		// System.out.println("Sandwich: " + sandwich);

		System.out.println("Sandwich");
		System.out.println("\t" + sandwich.getBreadType());
		System.out.println("\tIngredients: ");

		sandwich.getIngredients().forEach(i -> System.out.println("\t\t" + i.getName()));

		BigDecimal total = sandwich.getIngredients().stream().map(Ingredient::getCost).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		System.out.println("\tTotal: $" + total);
		System.out.println("------------------------------------");
		// System.exit(1);

	}

	@Bean
	public Ingredient provalone() {
		return new Ingredient("Provalone Cheese", new BigDecimal(0.25d));
	}

	@Bean
	public Ingredient cheddar() {
		return new Ingredient("Cheddar Cheese", new BigDecimal(0.30d));
	}

	@Bean
	public Ingredient ham() {
		return new Ingredient("Ham", new BigDecimal(1.55d));
	}

	@Bean
	public Ingredient turkey() {
		return new Ingredient("Turkey", new BigDecimal(1.00d));
	}

	@Bean
	public Ingredient sweetOnion() {
		return new Ingredient("Sweet Onion Sauce", new BigDecimal(5.50d));
	}
	
	
	
		public static User otherMain(String[] args) 
		{
			ConfigurableApplicationContext context = new SpringApplicationBuilder().sources(Application.class).run(args);
			return null;
		}
			
//			User u = context.getBean("student", User.class);
//				System.out.println(u.getFirstName());
//				System.out.println(u.getBirthday());
//				System.out.println(u.getAge());
		
		
			
			
			//SpringApplication.run(Application.class, args);
			//System.out.println("Hello");	
			
//		@Bean
//		public User student(){
//			User u = new User();
//			u.setActive(true);
//			u.setBirthday(LocalDate.of(1996, Calendar.MAY+1, 30));
//			u.setFirstName("Sydney");
//			u.setLastName("Haggard");
//			u.setNickname("Syd");
//			u.setId(1);
//			u.setTitle("Student");
//			u.setPhoneNumber("317.432.7144");
//			return u;
//		}
//		
//		@Bean
//		public User student1(){
//			User u2 = new User();
//			u2.setActive(true);
//			u2.setBirthday(LocalDate.of(1993, Calendar.JULY+1, 8));
//			u2.setFirstName("Erin");
//			u2.setLastName("Kelley");
//			u2.setNickname("Darling");
//			u2.setIdNum(2);
//			u2.setTitle("Student");
//			u2.setPhoneNumber("317.123.4567");
//			return u2;
//		}
	}
