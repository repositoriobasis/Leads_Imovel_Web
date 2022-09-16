package br.com.basissistemas.leads.imovelweb.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.basissistemas.leads.imovelweb.domain.model.BancoDeDados;

public interface BancoDeDadosRepository extends JpaRepository<BancoDeDados, Integer> {
	
	@Query("from BancoDeDados d where d.bancoNome = :bancoNome")
	Optional<BancoDeDados> findByBancoNome(String bancoNome);
	
	@Query("select bancoNome from BancoDeDados b where b.id = :idBancoDeDados ")
	String bancoDeDadosNome(Integer idBancoDeDados);
	
	@Query("from BancoDeDados b where b.bancoNome is not null and b.bancoPorta is not null")
	List<BancoDeDados> findByBancoNomeIsNotNull();

}
