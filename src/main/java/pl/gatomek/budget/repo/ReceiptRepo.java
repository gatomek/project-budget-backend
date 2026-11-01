package pl.gatomek.budget.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gatomek.budget.entity.Receipt;

@Repository
public interface ReceiptRepo extends JpaRepository<Receipt, Long> {
}
