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

    @GetMapping
    public ResponseEntity<RestResponse<List<CustomerDTO>>> findAll() {
        var customerDTOList = customerControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(customerDTOList));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<RestResponse<CustomerDTO>> findById(@PathVariable Long id) {
        var customerDTO = customerControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(customerDTO));
    }


}
