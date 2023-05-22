package com.polat.controller.contract;

import com.polat.dto.customer.CustomerDTO;
import com.polat.dto.customer.CustomerSaveRequest;

import java.util.List;

/**
 * @author MPolat
 */
public interface CustomerControllerContract {

    CustomerDTO save(CustomerSaveRequest request);

    List<CustomerDTO> findAll();

    CustomerDTO findById(Long id);

    List<CustomerDTO> findByNameIncludeC();

    Double getCustomersInvoiceCreatedJune();
}
