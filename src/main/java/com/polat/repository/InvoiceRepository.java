package com.polat.repository;

import com.polat.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MPolat
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
