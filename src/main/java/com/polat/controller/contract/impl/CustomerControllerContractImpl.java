package com.polat.controller.contract.impl;

import com.polat.controller.contract.CustomerControllerContract;
import com.polat.dto.customer.CustomerDTO;
import com.polat.dto.customer.CustomerSaveRequest;
import com.polat.mapper.CustomerMapper;
import com.polat.model.Customer;
import com.polat.model.Invoice;
import com.polat.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Customer> customerList = customerService.findAll();
        return customerList.stream()
                .map(CustomerMapper.INSTANCE::convertToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findById(Long id) {
        Customer customer = customerService.findByIdWithControl(id);
        return CustomerMapper.INSTANCE.convertToCustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> findByNameIncludeC() {
        List<Customer> customerList = customerService.findAll();

        return customerList.stream()
                .filter(customer -> customer.getName().toUpperCase().contains("C")
                        || customer.getSurname().toUpperCase().contains("C"))
                .map(CustomerMapper.INSTANCE::convertToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Double getCustomersInvoiceCreatedJune() {
        List<Customer> customerList = customerService.findAll();
        LocalDate juneStart = LocalDate.of(LocalDate.now().getYear(), Month.JUNE, 1);
        LocalDate juneEnd = LocalDate.of(LocalDate.now().getYear(), Month.JUNE, 30);

        return customerList.stream()
                .filter(customer -> customer.getBaseAdditionalFields().getCreateDate().toLocalDate().isAfter(juneStart)
                && customer.getBaseAdditionalFields().getCreateDate().toLocalDate().isBefore(juneEnd))
                .flatMap(customer -> customer.getInvoiceList().stream())
                .mapToDouble(Invoice::getAmount)
                .sum();
    }
}
