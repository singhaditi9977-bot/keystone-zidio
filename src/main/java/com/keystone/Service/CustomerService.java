package com.keystone.Service;

import java.util.List;
import com.keystone.DTO.CustomerDTO;

public interface CustomerService {

    CustomerDTO createcustomer(CustomerDTO cus);

    CustomerDTO updateCustomer(Long id, CustomerDTO cust);

    CustomerDTO getCustomer(Long id);

    List<CustomerDTO> getAllCustomer();

    void deleteCustomer(Long id);
}