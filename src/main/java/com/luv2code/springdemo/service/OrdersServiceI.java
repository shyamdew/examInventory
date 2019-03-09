package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lov2code.springdemo.dto.OrdersDTO;
import com.luv2code.springdemo.controller.GenericException;
import com.luv2code.springdemo.entity.Customer;

public interface OrdersServiceI {
	void generateOrders(OrdersDTO orders) throws GenericException;
}
