package pl.gatomek.budget.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gatomek.budget.entity.Receipt;
import pl.gatomek.budget.repo.ReceiptRepo;

@RequiredArgsConstructor
@Service
public class ReceiptService {

    private final ReceiptRepo receiptRepo;

    public void save(Receipt receipt) {
        receiptRepo.save(receipt);
    }
}
