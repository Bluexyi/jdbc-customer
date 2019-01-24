package fr.univ.paris8.iut.jdbccustomer.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.univ.paris8.iut.jdbccustomer.CustomerRowMapper;
import fr.univ.paris8.iut.jdbccustomer.model.Customer;

@RestController
public class CustomerCotroller {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@GetMapping("/customers")
	public List<Customer> findAll(){	
		return jdbcTemplate.query("SELECT * FROM customers", new CustomerRowMapper());
	}
	
}
