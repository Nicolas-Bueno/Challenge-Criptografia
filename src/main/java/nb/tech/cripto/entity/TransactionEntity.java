package nb.tech.cripto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import nb.tech.cripto.service.CriptoService;

@Entity
@Table(name = "tb_transactions")
public class TransactionEntity {

    public TransactionEntity() {}

    public TransactionEntity(Long transactionId, String encryptedUserDocument, String encryptedCreditCardToken, Long transactionValue, String rawUserDocument, String rawCreditCardToken) {
        this.transactionId = transactionId;
        this.encryptedUserDocument = encryptedUserDocument;
        this.encryptedCreditCardToken = encryptedCreditCardToken;
        this.transactionValue = transactionValue;
        this.rawUserDocument = rawUserDocument;
        this.rawCreditCardToken = rawCreditCardToken;
    }
    
    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(name = "user_document")
    private String encryptedUserDocument;

    @Column(name = "credit_card_token")
    private String encryptedCreditCardToken;

    @Column(name = "transaction_value")
    private Long transactionValue;

    @Transient
    private String rawUserDocument;

    @Transient
    private String rawCreditCardToken;


    public Long getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getEncryptedUserDocument() {
        return this.encryptedUserDocument;
    }

    public void setEncryptedUserDocument(String encryptedUserDocument) {
        this.encryptedUserDocument = encryptedUserDocument;
    }

    public String getEncryptedCreditCardToken() {
        return this.encryptedCreditCardToken;
    }

    public void setEncryptedCreditCardToken(String encryptedCreditCardToken) {
        this.encryptedCreditCardToken = encryptedCreditCardToken;
    }

    public Long getTransactionValue() {
        return this.transactionValue;
    }

    public void setTransactionValue(Long transactionValue) {
        this.transactionValue = transactionValue;
    }

    public String getRawUserDocument() {
        return this.rawUserDocument;
    }

    public void setRawUserDocument(String rawUserDocument) {
        this.rawUserDocument = rawUserDocument;
    }

    public String getRawCreditCardToken() {
        return this.rawCreditCardToken;
    }

    public void setRawCreditCardToken(String rawCreditCardToken) {
        this.rawCreditCardToken = rawCreditCardToken;
    }

    @PrePersist
    public void PrePersist(){
        this.encryptedUserDocument = CriptoService.encrypt(rawUserDocument);
        this.encryptedCreditCardToken = CriptoService.encrypt(rawCreditCardToken);
    }

    @PostLoad
    public void PostLoad(){
        this.rawUserDocument = CriptoService.dencrypt(encryptedUserDocument);
        this.rawCreditCardToken = CriptoService.dencrypt(encryptedCreditCardToken);
    }
    
}
