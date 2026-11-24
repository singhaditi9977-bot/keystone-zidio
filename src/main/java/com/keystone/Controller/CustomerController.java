package com.keystone.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.keystone.DTO.CustomerDTO;
import com.keystone.Service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/create")
	public ResponseEntity<CustomerDTO>createCustomer(@RequestBody CustomerDTO cus){
		return ResponseEntity.ok(customerService.createcustomer(cus));
	}
	@PutMapping("/update")
	public ResponseEntity<CustomerDTO>updateCustomer(@PathVariable Long id,@RequestBody CustomerDTO Cust){
		return ResponseEntity.ok(customerService.updateCustomer(id, Cust));
	}
	
	@GetMapping("/getCus/{id}")
	public ResponseEntity<CustomerDTO>getCustomer(@RequestParam Long id){
		return ResponseEntity.ok(customerService.getCustomer(id));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CustomerDTO>>getAllCustomer(){
		return ResponseEntity.ok(customerService.getAllCustomer());
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteCustomer(@RequestParam Long id){
	customerService.deleteCustomer(id);
	return ResponseEntity.ok("Customer deleted successfully");
	}
}
