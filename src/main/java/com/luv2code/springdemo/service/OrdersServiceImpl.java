package com.luv2code.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lov2code.springdemo.dto.Order;
import com.lov2code.springdemo.dto.OrdersDTO;
import com.luv2code.springdemo.controller.GenericException;
import com.luv2code.springdemo.dao.AccountDAO;
import com.luv2code.springdemo.dao.CatagoryDAO;
import com.luv2code.springdemo.dao.CommonDAO;
import com.luv2code.springdemo.entity.Inventory;
import com.luv2code.springdemo.entity.Orders;
import com.luv2code.springdemo.entity.OrdersDetail;
@Service
public class OrdersServiceImpl implements OrdersServiceI {
	@Autowired
	private CommonDAO commonDao;
	@Autowired
	private CatagoryDAO catagoryDAO;
	@Autowired
	private AccountDAO accountDAO;
	@Override
	@Transactional
	public void generateOrders(OrdersDTO ordersDTO) throws GenericException{
		// validate the customer
		if(ordersDTO.getFmtUserId() == null) {
			throw new GenericException(" Please provide valid fmt user id");
		}
		if(accountDAO.getInventory(ordersDTO.getFmtUserId()) == null) {
			throw new GenericException(" provided user does not exist in our system");
		}
		
		if(ordersDTO.getOrders() != null) {
			
			// Validate weather customer exist in our system
			// create Orders
			Orders orders = new Orders();
			orders.setCustomerId(ordersDTO.getFmtUserId());
			
			orders.setId(this.generateRRN());
			System.out.println(orders.getId());
			// Validate weather we can full fill the orders
			for(Order order: ordersDTO.getOrders()) {
				// Validate the order detail 
				Inventory  inventory =  catagoryDAO.getInventory(order.getProductId());
				if(inventory == null) {
					throw new GenericException(order.getProductId() + " Does not exist in our system currently");
					// Throw Exception say's Product does not exist
				}
				if( inventory.getQuantity() < order.getQuantity()) {
					// Throw Exception say's This product quantity not matches
					throw new GenericException(inventory.getName() + " cannot be palced.");
				}
				OrdersDetail ordersDetail = new OrdersDetail();
				ordersDetail.setOrderId(orders.getId());
				ordersDetail.setProductId(order.getProductId());
				ordersDetail.setQuantity(order.getQuantity());
				
				inventory.setQuantity(inventory.getQuantity() -  order.getQuantity() );
				
				commonDao.insertOrUpdateRecord( ordersDetail, CommonDAO.INSERT);
				commonDao.insertOrUpdateRecord( inventory, CommonDAO.MODIFY);
			}
			commonDao.insertOrUpdateRecord( orders, CommonDAO.INSERT);
			ordersDTO.setOrderId(orders.getId());
		}
	}
	int generateRRN() {
		// Right logic for generating unique rrn
		return (int) System.currentTimeMillis();
	}
}
