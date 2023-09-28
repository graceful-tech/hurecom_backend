package com.hurecom.respository.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hurecom.entity.customer.CustomerEntity;


@Repository
public interface CustomerRespository extends JpaRepository<CustomerEntity, Long> {

	
	
	
}
