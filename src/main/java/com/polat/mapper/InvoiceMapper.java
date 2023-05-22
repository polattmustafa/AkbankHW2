package com.polat.mapper;

import com.polat.dto.invoice.InvoiceDTO;
import com.polat.dto.invoice.InvoiceSaveRequest;
import com.polat.model.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author MPolat
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InvoiceMapper {

    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);

    Invoice convertToInvoice(InvoiceSaveRequest request);

    @Mapping(target = "customerId", source = "customer.id")
    InvoiceDTO convertToInvoiceDTO(Invoice invoice);

    List<InvoiceDTO> convertToInvoiceDTOList (List<Invoice> invoiceList);

}
