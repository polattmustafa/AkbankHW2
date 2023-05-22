package com.polat.repository;

import com.polat.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author MPolat
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    @Query("SELECT i.sector FROM Invoice i WHERE MONTH(i.amountDate) = 6 GROUP BY i.sector HAVING AVG(i.amount) < :threshold")
    List<String> findSectorByAverageAmountLessThan(@Param("threshold") double threshold);

}
