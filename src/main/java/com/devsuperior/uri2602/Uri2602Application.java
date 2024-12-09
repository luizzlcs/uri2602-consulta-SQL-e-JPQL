package com.devsuperior.uri2602;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2602.projections.CustomerMinProjection;
import com.devsuperior.uri2602.repositories.*;
import com.devsuperior.uri2602.dto.*;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {
	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("\n RESULTADO SQL RAÍZ");		
		List<CustomerMinProjection> list = repository.search1("rs");
		List<CustomerMinDTO> result1 = list.stream().map(x -> new CustomerMinDTO(x)).collect(Collectors.toList());

		for (CustomerMinDTO obj : result1) {
			System.out.println(obj);		
		}
		System.out.println("\n \n");


		System.out.println("\n RESULTADO JPQL");

		List<CustomerMinDTO> list2 = repository.search2("rs");

		for (CustomerMinDTO obj : list2) {
			System.out.println(obj);		
		}

	}
}
