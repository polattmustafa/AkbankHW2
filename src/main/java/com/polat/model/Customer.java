package com.polat.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MPolat
 */

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
public class Customer extends BaseModel{

    @Id
    @GeneratedValue(generator = "Customer", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Customer", sequenceName = "CUSTOMER_ID_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 50, nullable = false)
    private String surname;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "customer")
    private List<Invoice> invoiceList = new ArrayList<>();

}
