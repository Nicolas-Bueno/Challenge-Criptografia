package nb.tech.cripto.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import nb.tech.cripto.controller.dto.CreateTransactionRequest;
import nb.tech.cripto.controller.dto.TransactionResponse;
import nb.tech.cripto.entity.TransactionEntity;
import nb.tech.cripto.repository.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository repository;


    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public void create(CreateTransactionRequest request){
        var entity = new TransactionEntity();
        entity.setRawCreditCardToken(request.creditCardToken());
        entity.setRawUserDocument(request.userDocument());
        entity.setTransactionValue(request.value());

        repository.save(entity);
    }

    public Page<TransactionResponse> listAll(int page, int pageSize) {

        var content = repository.findAll(PageRequest.of(page, pageSize));

        return content.map(TransactionResponse::fromEntity);
    }

}
