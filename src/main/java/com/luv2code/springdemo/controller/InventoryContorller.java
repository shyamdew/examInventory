package com.luv2code.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lov2code.springdemo.dto.OrdersDTO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.OrdersServiceI;

@Controller
@RequestMapping("/inventory")
public class InventoryContorller {
	@Autowired 
	private OrdersServiceI orderService;
	@PostMapping("/orders")
	public @ResponseBody OrdersDTO addOrders(@RequestBody OrdersDTO request) throws GenericException{
		System.out.println("Coming to generate the orders "+ request);
		this.orderService.generateOrders(request);
		return request;
	}
}
