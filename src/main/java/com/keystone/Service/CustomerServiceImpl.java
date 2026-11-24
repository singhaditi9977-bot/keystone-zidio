package com.keystone.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keystone.DTO.CustomerDTO;
import com.keystone.Entity.Customer;
import com.keystone.Repositery.CustomerRespositery;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRespositery customerRepo;
	
	@Override
	public CustomerDTO createcustomer(CustomerDTO cus) {
		
		if(customerRepo.existsByUserEmail(cus.customerEmail)) {
			throw new RuntimeException("Customer already exist");
		}
		Customer customer = new Customer();
		customer.setUserEmail(cus.customerEmail);
		customer.setPhone(cus.customerPhone);
		customer.setAddress(cus.address);
		customer.setContactPerson(cus.contactPerson);
		customer.setActive(true);
		customer.setCreateAt(LocalDateTime.now());
		
		customerRepo.save(customer);
		
		return mapDTO(customer); 
	}
	
	public CustomerDTO updateCustomer(Long id,CustomerDTO cust) {
		
		Customer customer = customerRepo.findById(id).orElseThrow(()-> new RuntimeException("Customer not found"));
		customer.setContactPerson(cust.contactPerson);
		customer.setPhone(cust.customerPhone);
		customer.setAddress(cust.address);
		customerRepo.save(customer);
		
		return mapDTO(customer);
		
		}
	@Override
	public CustomerDTO getCustomer(Long id) {
		Customer customer =customerRepo.findById(id).orElseThrow(()-> new RuntimeException("Customer not found"));
		return mapDTO(customer);
	}
	
	@Override
	public List<CustomerDTO>getAllCustomer(){
		return customerRepo.findAll().stream().map(this::mapDTO).collect(Collectors.toList());
	}
	
	@Override
	public void deleteCustomer(Long id) {
		customerRepo.deleteById(id);
	}
	
	private CustomerDTO mapDTO(Customer customers) {
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomerEmail(customers.getUserEmail());
		dto.setCustomerPhone(customers.getPhone());
		dto.setAddress(customers.getAddress());
		dto.setContactPerson(customers.getContactPerson());
		dto.setActive(customers.isActive());
		
		return dto;
		
	}
	
	
	
	
}
