package br.com.basissistemas.leads.imovelweb.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.basissistemas.leads.imovelweb.domain.model.Lead;
import br.com.basissistemas.leads.imovelweb.domain.repository.LeadRepository;

@Service
public class LeadService {
	
	@Autowired
	LeadRepository leadRepository;
	
	public Lead salvar(Lead lead) {
		return leadRepository.save(lead);
	}

}
