package pl.gatomek.budget.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gatomek.budget.entity.Receipt;
import pl.gatomek.budget.repo.ReceiptRepo;

import java.time.Instant;

@RequiredArgsConstructor
@Service
public class ReceiptService {

    private final ReceiptRepo receiptRepo;

    public void saveNewReceipt(String type, byte[] content) {
        Receipt receipt = Receipt.builder()
                .timestamp(Instant.now())
                .type(type)
                .data(content)
                .build();

        receiptRepo.save(receipt);
    }
}
