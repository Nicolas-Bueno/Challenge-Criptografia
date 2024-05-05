package nb.tech.cripto.controller.dto;

import nb.tech.cripto.entity.TransactionEntity;

public record TransactionResponse(Long id,
                                String userDocument,
                                String creditCardToken,
                                Long value) {

    public static TransactionResponse fromEntity(TransactionEntity entity) {
        return new TransactionResponse(
            entity.getTransactionId(),
            entity.getRawUserDocument(),
            entity.getRawCreditCardToken(),
            entity.getTransactionValue()
        );
    }
} 
