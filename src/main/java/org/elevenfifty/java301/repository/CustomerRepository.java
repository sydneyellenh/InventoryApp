package org.elevenfifty.java301.repository;


import org.elevenfifty.java301.beans.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	
	
}