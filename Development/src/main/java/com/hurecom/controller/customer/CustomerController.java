package com.hurecom.controller.customer;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hurecom.controller.BaseController;

import com.hurecom.dto.customer.CustomerDto;
import com.hurecom.service.customer.CustomerService;
import com.hurecom.utility.CommonConstants;

@RestController
@RequestMapping("/customers")
public class CustomerController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerService customerService;

	/*
	 * This controller is used to create Customer.
	 */
	@PostMapping("/create")
	public ResponseEntity<?> createCustomer(@RequestBody CustomerDto customerDto) throws Exception {
		logger.debug("Controller :: createCandidate :: Entered");

		Long candidateId = customerService.createCustomer(customerDto);

		logger.debug("Controller :: createCandidate :: Exited");

		if (Objects.isNull(candidateId)) {
			return new ResponseEntity<>(buildResponse(CommonConstants.HM_0003), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(candidateId, HttpStatus.OK);
	}
}
