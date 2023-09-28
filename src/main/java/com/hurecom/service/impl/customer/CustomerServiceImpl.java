package com.hurecom.service.impl.customer;

import java.time.LocalDateTime;
import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hurecom.dto.customer.CustomerDto;

import com.hurecom.entity.customer.CustomerEntity;
import com.hurecom.exception.HurecomException;
import com.hurecom.respository.customer.CustomerRespository;
import com.hurecom.service.customer.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	@Autowired
	CustomerRespository customerRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public Long createCustomer(CustomerDto customerDto) {
		logger.debug("Service :: createCustomer :: Entered");
		Long customerId = null;
		try {
			CustomerEntity candidateEntity = convertDtoToEntity(customerDto);
			CustomerEntity savedEntity = customerRepository.save(candidateEntity);

			if (Objects.nonNull(savedEntity)) {
				customerId = savedEntity.getId();
			}
		} catch (Exception e) {
			logger.error("Service :: createCustomer :: Exception :: " + e.getMessage());

			if (e instanceof HurecomException) {
				throw e;
			}
		}
		logger.debug("Service :: createCustomer :: Exited");
		return customerId;
	}

	private CustomerEntity convertDtoToEntity(CustomerDto customerDto) {

		logger.debug("Service :: convertDtoToEntity :: Entered");
		CustomerEntity customerEntity = null;
		try {
			customerEntity = modelMapper.map(customerDto, CustomerEntity.class);

			customerEntity.setCreatedDate(LocalDateTime.now());

			customerEntity.setModifiedDate(LocalDateTime.now());
		} catch (Exception e) {
			logger.error("Service :: convertDtoToEntity :: Exception :: " + e.getMessage());
		}
		logger.debug("Service :: convertDtoToEntity :: Exited");
		return customerEntity;

	}
}
