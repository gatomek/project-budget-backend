package pl.gatomek.budget.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "RECEIPT", schema = "BUDGET")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "receipt-id-generator")
    @SequenceGenerator(name = "receipt-id-generator", schema = "budget", sequenceName = "receipt_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "timestamp")
    private Instant timestamp;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "data")
    private byte[] data;
}
