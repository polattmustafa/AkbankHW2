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

    @PostMapping("/save/{id}")
    public ResponseEntity<RestResponse<InvoiceDTO>> save(@RequestBody InvoiceSaveRequest request, @PathVariable Long id) {
        var invoiceDTO = invoiceControllerContract.save(request, id);
        return ResponseEntity.ok(RestResponse.of(invoiceDTO));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<InvoiceDTO>>> findAll() {
        var invoiceDTOList = invoiceControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(invoiceDTOList));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<RestResponse<InvoiceDTO>> findById(@PathVariable Long id) {
        var invoiceDTO = invoiceControllerContract.findById(id);
        return ResponseEntity.ok(RestResponse.of(invoiceDTO));
    }

}
