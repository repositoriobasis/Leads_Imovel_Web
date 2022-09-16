package br.com.basissistemas.leads.imovelweb.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.basissistemas.leads.imovelweb.domain.exception.BancoDeDadosNaoEncontradoException;
import br.com.basissistemas.leads.imovelweb.domain.model.BancoDeDados;
import br.com.basissistemas.leads.imovelweb.domain.repository.BancoDeDadosRepository;

@Service
public class BancoDeDadosService {
	
	@Autowired
	BancoDeDadosRepository bancoDeDadosRepository;
	
	public BancoDeDados buscarOuFalhar(String codigo) {
		return bancoDeDadosRepository.findByBancoNome("wb".concat(codigo)).orElseThrow(() -> new BancoDeDadosNaoEncontradoException(codigo));
	}

}
