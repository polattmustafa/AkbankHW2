package com.polat.controller.contract.impl;

import com.polat.controller.contract.InvoiceControllerContract;
import com.polat.dto.invoice.InvoiceDTO;
import com.polat.dto.invoice.InvoiceSaveRequest;
import com.polat.general.Constants;
import com.polat.mapper.InvoiceMapper;
import com.polat.model.Customer;
import com.polat.model.Invoice;
import com.polat.service.CustomerService;
import com.polat.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author MPolat
 */

@Service
@RequiredArgsConstructor
public class InvoiceControllerContractImpl implements InvoiceControllerContract {

    private final InvoiceService invoiceService;

    private final CustomerService customerService;

    @Override
    public InvoiceDTO save(InvoiceSaveRequest request) {
        Customer customer = customerService.findByIdWithControl(request.customerId());

        Invoice invoice = InvoiceMapper.INSTANCE.convertToInvoice(request);
        invoice.setAmountDate(LocalDateTime.now());
        invoice.setCustomer(customer);

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

    @Override
    public List<InvoiceDTO> findInvoicesAbove() {
        double threshold = Constants.INVOICE_AMOUNT_THRESHOLD;
        List<Invoice> invoiceList = invoiceService.findAll();

        return invoiceList.stream()
                .filter(invoice -> invoice.getAmount() > threshold)
                .map(InvoiceMapper.INSTANCE::convertToInvoiceDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Double findAverageInvoicesAbove() {
        double threshold = Constants.INVOICE_AMOUNT_THRESHOLD;
        List<Invoice> invoiceList = invoiceService.findAll();

        return invoiceList.stream()
                .filter(invoice -> invoice.getAmount() > threshold)
                .mapToDouble(Invoice::getAmount)
                .average()
                .orElse(0.0);
    }

    @Override
    public List<String> findCustomersBelowAmount() {
        double threshold = Constants.INVOICE_AMOUNT_BELOW;
        List<Customer> customerList = customerService.findAll();
        return customerList.stream()
                .flatMap(customer -> customer.getInvoiceList().stream())
                .filter(invoice -> invoice.getAmount() < threshold)
                .map(Invoice::getCustomer)
                .map(Customer::getName)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findSectorBelowAmount() {
        double threshold = Constants.AVERAGE_THRESHOLD;
        return invoiceService.findSectorByAverageAmountLessThan(threshold);
    }


}
