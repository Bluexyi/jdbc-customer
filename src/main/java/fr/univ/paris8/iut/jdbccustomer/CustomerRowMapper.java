package fr.univ.paris8.iut.jdbccustomer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import fr.univ.paris8.iut.jdbccustomer.model.Customer;
public class CustomerRowMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"));
	}

}