package com.polat.dto.customer;

import com.polat.model.Invoice;

import java.util.List;

/**
 * @author MPolat
 */
public record CustomerDTO(Long id,
                          String name,
                          String surname) {
}
