package com.polat.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author MPolat
 */

@Getter
@Setter
@Embeddable
public class BaseAdditionalFields {

    @Column(name = "CUSTOMER_CREATED_BY")
    private String createdBy;

    @Column(name = "CUSTOMER_UPDATE_BY")
    private String updatedBy;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;

}
