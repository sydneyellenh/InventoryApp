package org.elevenfifty.java301.sandwich;


import java.math.BigDecimal;


import org.elevenfifty.java301.sandwich.Sandwich.BreadType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(Application.class, args);
		
	}
	
	
	
	
	
	////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////
	public static void oldMain(String[] args) 
	{
		
		ConfigurableApplicationContext context = new SpringApplicationBuilder().sources(Application.class).run(args);
	
		
		System.out.println("--------------------------------------------");
		
		//Code here
		
		Sandwich sandwich = new Sandwich(BreadType.WHEAT);
		sandwich.addIngredient(context.getBean("turkey", Ingredient.class));
		sandwich.addIngredient(context.getBean("ham", Ingredient.class));
		sandwich.addIngredient(context.getBean("cheddar", Ingredient.class));
		sandwich.addIngredient(context.getBean("sweetOnion", Ingredient.class));
		
		//System.out.println("Sandwich: " + sandwich);
		
		System.out.println("Sandwich");
		System.out.println("\t" + sandwich.getBreadType());
		System.out.println("\tIngredients: ");
		
		sandwich.getIngredients().forEach(i -> System.out.println("\t\t" + i.getName()));	
		
		BigDecimal total = sandwich.getIngredients()
				.stream()
				.map(Ingredient::getCost)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println("\tTotal: $" + total);
		System.out.println("------------------------------------");
		//System.exit(1);

	}
	
	@Bean
	public Ingredient provalone(){
		return new Ingredient ("Provalone Cheese",  new BigDecimal(0.25d));
	}
	
	@Bean
	public Ingredient cheddar(){
		return new Ingredient ("Cheddar Cheese",  new BigDecimal(0.30d));
	}
	
	@Bean
	public Ingredient ham(){
		return new Ingredient ("Ham",  new BigDecimal(1.55d));
	}
	
	@Bean
	public Ingredient turkey(){
		return new Ingredient ("Turkey",  new BigDecimal(1.00d));
	}
	
	@Bean
	public Ingredient sweetOnion(){
		return new Ingredient ("Sweet Onion Sauce",  new BigDecimal(5.50d));
	}
	
	}
	
