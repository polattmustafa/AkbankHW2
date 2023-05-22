package com.polat.controller.contract.impl;

import com.polat.controller.contract.InvoiceControllerContract;
import com.polat.dto.invoice.InvoiceDTO;
import com.polat.dto.invoice.InvoiceSaveRequest;
import com.polat.mapper.InvoiceMapper;
import com.polat.model.Invoice;
import com.polat.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MPolat
 */

@Service
@RequiredArgsConstructor
public class InvoiceControllerContractImpl implements InvoiceControllerContract {

    private final InvoiceService invoiceService;

    @Override
    public InvoiceDTO save(InvoiceSaveRequest request) {
        Invoice invoice = InvoiceMapper.INSTANCE.convertToInvoice(request);
        invoice = invoiceService.save(invoice);

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
