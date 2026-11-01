package pl.gatomek.budget.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.gatomek.budget.entity.Receipt;
import pl.gatomek.budget.service.ReceiptService;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.Instant;

@RequiredArgsConstructor
@Component
public class Runner implements CommandLineRunner {

    private final ReceiptService receiptService;

    @Override
    public void run(String... args) {

        Receipt receipt = new Receipt();
        receipt.setTimestamp(Instant.now());
        receipt.setPrice(BigDecimal.valueOf(10.4));
        receipt.setData("Test".getBytes(StandardCharsets.UTF_8));

        receiptService.save(receipt);
    }
}
