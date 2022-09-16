package br.com.basissistemas.leads.imovelweb.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.basissistemas.leads.imovelweb.api.dto.Imovelweb;
import br.com.basissistemas.leads.imovelweb.domain.model.Lead;
import br.com.basissistemas.leads.imovelweb.domain.service.BancoDeDadosService;
import br.com.basissistemas.leads.imovelweb.domain.service.LeadService;

@RestController
@RequestMapping("/v1/imobiliarias/{codigoCliente}")
public class ImovelwebController {
	
	@Autowired
	LeadService leadService;
	
	@Autowired
	BancoDeDadosService bancoDeDadosService;
	
	@GetMapping
    public Lead lead(@PathVariable String codigoCliente, @RequestBody Imovelweb leadImovelweb){
		
		Lead lead = Lead.builder()
				.identificador("Imovelweb")
				.imovelContato(leadImovelweb.getCodigoAviso())
				.nomeContato(leadImovelweb.getNombre())
				.emailContato(leadImovelweb.getEmail())
				.telefoneContato(leadImovelweb.getTelefono())
				.mensagemContato(leadImovelweb.getTextoMensaje())
				.idBancoDeDados(83)
				.usuarioCadastrou("API Imovelweb")
				.usuarioAtualizou("API Imovelweb")
				.build();
		
		return leadService.salvar(lead);
		
    }

}
