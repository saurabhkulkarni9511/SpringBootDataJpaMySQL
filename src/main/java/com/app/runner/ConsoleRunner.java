package com.app.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.model.Product;
import com.app.repo.ProductRepsitory;

@Component
public class ConsoleRunner implements CommandLineRunner{

	@Autowired
	private ProductRepsitory repo;


	@Override
	public void run(String... args) throws Exception {
		repo.save(new Product(10,"A",3.3));
		repo.save(new Product(11,"B",4.4));
		repo.save(new Product(12,"C",5.5));
		repo.save(new Product(13,"D",6.6));

		//--Update all--
		repo.save(new Product(13,"E",8.8));


		//--Bulk insert-- 
		List<Product> prds=Arrays.asList( new Product(101,"R",9.9),
				new Product(102,"E",8.8), 
				new Product(103,"T",7.7), 
				new Product(104,"G",6.6)
				); 
		repo.saveAll(prds);

		//--fetch one row-- 
		Optional<Product> p=repo.findById(13); 
		if(p.isPresent())
		{ 
			Product prd=p.get(); 
			System.out.println(prd.getProdCode()); 
		}else {
			System.out.println("Row Not Found"); 
		}

		//--fetch all rows-- 
		List<Product> list= repo.findAll();
		list.forEach(System.out::println);
		
		//--delete all rows-- 
		repo.deleteById(10);

		//--delete all rows-- 
		repo.deleteAll(); 
		repo.deleteAllInBatch();

	}

}
