package com.polat.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author MPolat
 */

@Entity
@Table(name = "INVOICE")
@Getter
@Setter
public class Invoice extends BaseModel{

    @Id
    @GeneratedValue(generator = "Customer", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Customer", sequenceName = "CUSTOMER_ID_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "AMOUNTDATE")
    private LocalDateTime amountDate;

    @Column(name = "SECTOR", length = 50)
    private String sector;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CUSTOMER", nullable = false)
    Customer customer;

}
