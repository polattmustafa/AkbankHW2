package com.polat.service;

import com.polat.model.Invoice;
import com.polat.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MPolat
 */

@Service
public class InvoiceService extends BaseModelService<Invoice, InvoiceRepository>{

    public InvoiceService(InvoiceRepository anyRepo) {
        super(anyRepo);
    }

    public List<String> findSectorByAverageAmountLessThan(double threshold) {
        return getAnyRepo().findSectorByAverageAmountLessThan(threshold);
    }

}
