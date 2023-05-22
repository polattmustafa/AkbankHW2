package com.polat.service;

import com.polat.model.Customer;
import com.polat.repository.CustomerRepository;
import org.springframework.stereotype.Service;

/**
 * @author MPolat
 */

@Service
public class CustomerService extends BaseModelService<Customer, CustomerRepository> {

    public CustomerService(CustomerRepository anyRepo) {
        super(anyRepo);
    }
}
