package fr.univ.paris8.iut.jdbccustomer;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import fr.univ.paris8.iut.jdbccustomer.model.Customer;

@SpringBootApplication
public class JdbcCustomerApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(JdbcCustomerApplication.class);

    public static void main(String args[]) {
        SpringApplication.run(JdbcCustomerApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
    	createTable();
    	insertValues();

    	/*List<Customer> customers= findBySurname("Josh");
    	for (Customer customer : customers) {
    		log.info(customer.toString());
    	}*/

    }

    public void insertValues() {
      Customer c1 = new Customer(1,"toto","lolo");
      Customer c2 = new Customer(2,"titi","lili");
      Customer c3 = new Customer(3,"tata","lala");
      Customer c4 = new Customer(4,"tutu","lulu");
      
      List<Customer> listCustomer =Arrays.asList(c1,c2,c3,c4);
      
      for (Customer customer : listCustomer) {
		insertCustomer(customer);
	}

    }

    public void createTable() {
    	 log.info("Creating tables");

         jdbcTemplate.execute("DROP TABLE IF EXISTS customers");
         jdbcTemplate.execute("CREATE TABLE customers(" +
                 "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");
    }
    /**
     * @param newCusto : the Customer to be added in database
     */
    public void insertCustomer(Customer newCusto) {
    	jdbcTemplate.update(
    			"INSERT INTO customers(first_name, last_name) VALUES (?,?)",
    			newCusto.getFirstName(),
    			newCusto.getLastName()
    			);
    }

}
