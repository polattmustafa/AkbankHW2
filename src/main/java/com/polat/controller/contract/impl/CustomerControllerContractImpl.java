package com.polat.controller.contract.impl;

import com.polat.controller.contract.CustomerControllerContract;
import com.polat.dto.customer.CustomerDTO;
import com.polat.dto.customer.CustomerSaveRequest;
import com.polat.mapper.CustomerMapper;
import com.polat.model.Customer;
import com.polat.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MPolat
 */
@Service
@RequiredArgsConstructor
public class CustomerControllerContractImpl implements CustomerControllerContract {

    private final CustomerService customerService;

    @Override
    public CustomerDTO save(CustomerSaveRequest request) {
        Customer customer = CustomerMapper.INSTANCE.convertToCustomer(request);

        customer = customerService.save(customer);

        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> customers = customerService.findAll();
        return CustomerMapper.INSTANCE.convertToCustomerDTOList(customers);
    }

    @Override
    public CustomerDTO findById(Long id) {
        Customer customer = customerService.findByIdWithControl(id);
        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }
}
