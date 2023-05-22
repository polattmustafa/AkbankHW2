package com.polat.controller.contract;

import com.polat.dto.invoice.InvoiceDTO;
import com.polat.dto.invoice.InvoiceSaveRequest;

import java.util.List;

/**
 * @author MPolat
 */
public interface InvoiceControllerContract {

    InvoiceDTO save(InvoiceSaveRequest request);

    List<InvoiceDTO> findAll();

    InvoiceDTO findById(Long id);

    List<InvoiceDTO> findInvoicesAbove();

    Double findAverageInvoicesAbove();

    List<String> findCustomersBelowAmount();

    List<String> findSectorBelowAmount();
}
