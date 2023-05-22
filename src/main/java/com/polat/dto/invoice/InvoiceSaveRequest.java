package com.polat.dto.invoice;

import com.polat.dto.customer.CustomerSaveRequest;

/**
 * @author MPolat
 */
public record InvoiceSaveRequest(Double amount,
                                 String sector,
                                 Long customerId) {
}
