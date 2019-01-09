package com.springmondb.example.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.springmondb.example.models.Company;
import com.springmondb.example.models.Contact;
import com.springmondb.example.models.Product;
import com.springmondb.example.service.SpringMongoService;


@SpringBootApplication(scanBasePackages={"com.springmondb.example"})
@EnableMongoRepositories("com.springmondb.example") 
public class SpringDataMongoDbApplication implements CommandLineRunner{
	
	@Autowired
	SpringMongoService  springMongoService;

	@Override
	public void run(String... args) throws Exception {
		
		
		// save Documents to MongoDB
		System.out.println("==========Save list of company entities==========");
		springMongoService.create(Arrays.asList(
				// Apple company & products
				new Company(1, "Apple",
						
						        // list of products
								Arrays.asList(new Product("A-123", "Iphone 7", "Price: 649.00 USD & FREE shipping"),
													  new Product("A-456", "IPadPro", "Price: 417.67 USD & FREE shipping")),
								
								// contact
								new Contact("Cupertino, CA 95014", "1-408-996-1010")),
				
				// Samsung company & products
				new Company(2, "Samsung",
						
						       // list of products
						       Arrays.asList(new Product("S-012", "GalaxyJ7", "Price: 219.00 USD & FREE shipping"),
														new Product("S-456", "GalaxyTabA", "Price: 299.99 USD & FREE shipping")),
						       
						       // contact
						       new Contact("Seocho District, Seoul, South Korea", "+82-2-2053-3000"))));
		// initial List Companies variable
		List<Company> companies = null;
		
		// fetch all documents
		System.out.println("==========Fetch aLL companies:==========");
		companies = springMongoService.readAll();
		companies.forEach(System.out::println);
		
		// find Company by name
		System.out.println("==========Find a company by name:==========");
		companies = springMongoService.getByName("Samsung");
		companies.forEach(System.out::println);
		
		// find Company by address
		System.out.println("==========Find a company by address:==========");
		companies = springMongoService.getByAddress("Cupertino, CA 95014");
		companies.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataMongoDbApplication.class, args);
	}
}