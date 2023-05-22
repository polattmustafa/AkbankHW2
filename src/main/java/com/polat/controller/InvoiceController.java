package com.polat.controller;

import com.polat.controller.contract.InvoiceControllerContract;
import com.polat.dto.invoice.InvoiceDTO;
import com.polat.dto.invoice.InvoiceSaveRequest;
import com.polat.general.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MPolat
 */

@RestController
@RequestMapping("/api/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceControllerContract invoiceControllerContract;

    @PostMapping("/save")
    public ResponseEntity<RestResponse<InvoiceDTO>> save(@RequestBody InvoiceSaveRequest request) {
        var invoiceDTO = invoiceControllerContract.save(request);
        return ResponseEntity.ok(RestResponse.of(invoiceDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<RestResponse<List<InvoiceDTO>>> findAll() {
        var invoiceDTOList = invoiceControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(invoiceDTOList));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<RestResponse<InvoiceDTO>> findById(@PathVariable Long id) {
        var invoiceDTO = invoiceControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(invoiceDTO));
    }

    @GetMapping("/above")
    public ResponseEntity<RestResponse<List<InvoiceDTO>>> findInvoicesAbove() {
        var invoiceDTOList = invoiceControllerContract.findInvoicesAbove();
        return ResponseEntity.ok(RestResponse.of(invoiceDTOList));
    }

    @GetMapping("/average")
    public ResponseEntity<RestResponse<String>> findAverageInvoicesAbove() {
        var averageAmount = invoiceControllerContract.findAverageInvoicesAbove();
        return ResponseEntity.ok(RestResponse.of(
                String.format("The average of invoices over 1500 TL in the system: %s", averageAmount)));
    }

    @GetMapping("/name")
    public ResponseEntity<RestResponse<List<String>>> findCustomersBelowAmount() {
        var nameList = invoiceControllerContract.findCustomersBelowAmount();
        return ResponseEntity.ok(RestResponse.of(nameList));
    }

    @GetMapping("/sector")
    public ResponseEntity<RestResponse<List<String>>> findSectorBelowAmount() {
        var sectorList = invoiceControllerContract.findSectorBelowAmount();
        return ResponseEntity.ok(RestResponse.of(sectorList));
    }


}
