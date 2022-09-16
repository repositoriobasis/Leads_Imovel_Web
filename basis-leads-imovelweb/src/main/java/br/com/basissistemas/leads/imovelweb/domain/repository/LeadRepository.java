package br.com.basissistemas.leads.imovelweb.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.basissistemas.leads.imovelweb.domain.model.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {

}
