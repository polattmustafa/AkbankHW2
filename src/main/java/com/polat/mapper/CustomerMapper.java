package com.polat.mapper;

import com.polat.dto.customer.CustomerDTO;
import com.polat.dto.customer.CustomerSaveRequest;
import com.polat.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author MPolat
 */

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer convertToCustomer(CustomerSaveRequest customerSaveRequest);

    CustomerDTO convertToCustomerDTO(Customer customer);

    List<CustomerDTO> convertToCustomerDTOList (List<Customer> customers);

}
