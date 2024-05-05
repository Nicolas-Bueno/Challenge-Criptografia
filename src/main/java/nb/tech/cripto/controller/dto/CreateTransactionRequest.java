package nb.tech.cripto.controller.dto;

public record CreateTransactionRequest(String userDocument,
                                        String creditCardToken,
                                        Long value) {

}
