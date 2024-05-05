package nb.tech.cripto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nb.tech.cripto.entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Long>{

}
