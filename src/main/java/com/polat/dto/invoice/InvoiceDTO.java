package com.polat.dto.invoice;

import com.polat.dto.customer.CustomerDTO;
import com.polat.model.Customer;

import java.time.LocalDateTime;

/**
 * @author MPolat
 */
public record InvoiceDTO(Long id,
                         Double amount,
                         LocalDateTime amountDate,
                         Long customerId) {
}
