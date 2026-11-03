package pl.gatomek.budget.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pl.gatomek.budget.service.ReceiptService;

import java.io.IOException;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/receipt")
public class ReceiptController {

    private final ReceiptService receiptService;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void uploadNewReceipt(@RequestPart(name = "file") MultipartFile file) throws IOException {
        receiptService.saveNewReceipt(file.getContentType(), file.getBytes());
    }
}
