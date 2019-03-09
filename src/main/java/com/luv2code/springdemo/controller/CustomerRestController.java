package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.exception.ErrorResponse;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/crm")
public class CustomerRestController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if (theCustomer == null) {
			throw new GenericException("Customer id not found - " + customerId);
		}
		
		return theCustomer;
	}
	// add mapping for post /customer -  add new customer
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer theCustomer) {
//		System.out.println("Call recieved for adding customer"+ theCustomer);
		theCustomer.setId(customerService.getId());
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	@PutMapping("/customers")
	public Customer modifiyCustomer(@RequestBody Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	@DeleteMapping("/customers/{customerId}")
	public ErrorResponse deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
		ErrorResponse error = new ErrorResponse();
		error.setStatus(0);
		error.setMessage("customers id " + customerId + " has been deleted successfully.");
		error.setTimeStamp(System.currentTimeMillis());
		return error;
	}
}
