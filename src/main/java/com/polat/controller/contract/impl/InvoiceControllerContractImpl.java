package com.polat.controller.contract.impl;

import com.polat.controller.contract.InvoiceControllerContract;
import com.polat.dto.invoice.InvoiceDTO;
import com.polat.dto.invoice.InvoiceSaveRequest;
import com.polat.mapper.InvoiceMapper;
import com.polat.model.Customer;
import com.polat.model.Invoice;
import com.polat.service.CustomerService;
import com.polat.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MPolat
 */

@Service
@RequiredArgsConstructor
public class InvoiceControllerContractImpl implements InvoiceControllerContract {

    private final InvoiceService invoiceService;

    private final CustomerService customerService;

    @Override
    public InvoiceDTO save(InvoiceSaveRequest request, Long id) {
        Customer customer = customerService.findByIdWithControl(id);
        Invoice invoice = InvoiceMapper.INSTANCE.convertToInvoice(request);

        if (customer != null) {
            invoice.setAmountDate(LocalDateTime.now());
            invoice.setCustomer(customer);
            invoice = invoiceService.save(invoice);
        }

        return InvoiceMapper.INSTANCE.convertToInvoiceDTO(invoice);
    }

    @Override
    public List<InvoiceDTO> findAll() {
        List<Invoice> invoiceList = invoiceService.findAll();
        return InvoiceMapper.INSTANCE.convertToInvoiceDTOList(invoiceList);
    }

    @Override
    public InvoiceDTO findById(Long id) {
        Invoice invoice = invoiceService.findByIdWithControl(id);
        return InvoiceMapper.INSTANCE.convertToInvoiceDTO(invoice);
    }
}
