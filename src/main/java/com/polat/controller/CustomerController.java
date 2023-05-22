package com.polat.controller;

import com.polat.controller.contract.CustomerControllerContract;
import com.polat.dto.customer.CustomerDTO;
import com.polat.dto.customer.CustomerSaveRequest;
import com.polat.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MPolat
 */

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerControllerContract customerControllerContract;

    @PostMapping("/save")
    public ResponseEntity<RestResponse<CustomerDTO>> save(@RequestBody CustomerSaveRequest customerSaveRequest) {
        var customerDTO = customerControllerContract.save(customerSaveRequest);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<RestResponse<List<CustomerDTO>>> findAll() {
        var customerDTOList = customerControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(customerDTOList));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<RestResponse<CustomerDTO>> findById(@PathVariable Long id) {
        var customerDTO = customerControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }

    @GetMapping("/c")
    public ResponseEntity<RestResponse<List<CustomerDTO>>> findByNameIncludeC() {
        var customerDTOList = customerControllerContract.findByNameIncludeC();
        return ResponseEntity.ok(RestResponse.of(customerDTOList));
    }

    @GetMapping("/june")
    public ResponseEntity<RestResponse<String>> getCustomersInvoiceCreatedJune() {
        Double totalAmount = customerControllerContract.getCustomersInvoiceCreatedJune();
        return ResponseEntity.ok(RestResponse.of(
                String.format("The total amount of invoices for customers who signed up in June => %s",totalAmount)));
    }


}
