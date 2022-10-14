package br.com.basissistemas.leads.imovelweb.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.basissistemas.leads.imovelweb.api.dto.Imobiliaria;
import br.com.basissistemas.leads.imovelweb.api.dto.Mensagem;
import br.com.basissistemas.leads.imovelweb.core.RestPageImpl;
import br.com.basissistemas.leads.imovelweb.domain.service.ImobiliariaService;
import br.com.basissistemas.leads.imovelweb.domain.service.LeadService;
import br.com.basissistemas.leads.imovelweb.domain.service.MensagemService;


// Não está em uso, foi usado para testes.


@RestController
@RequestMapping("/v1/imobiliarias")
//@RequestMapping("/v1/imobiliarias/15439441/mensagens")
//@RequestMapping("/v1/imobiliarias/{codigoCliente}")
public class ImovelwebController {
	
	@Autowired
	LeadService leadService;
	
	@Autowired
	ImobiliariaService imobiliariaService;
	
	@Autowired
	MensagemService mensagemService;
	
//	@GetMapping
//    public Lead lead(@PathVariable String codigoCliente, @RequestBody Mensagem leadImovelweb){
//		
//		Lead lead = Lead.builder()
//				.identificador("Imovelweb")
//				.imovelContato(leadImovelweb.getCodigoAviso())
//				.nomeContato(leadImovelweb.getNombre())
//				.emailContato(leadImovelweb.getEmail())
//				.telefoneContato(leadImovelweb.getTelefono())
//				.mensagemContato(leadImovelweb.getTextoMensaje())
//				.idBancoDeDados(83)
//				.usuarioCadastrou("API Imovelweb")
//				.usuarioAtualizou("API Imovelweb")
//				.build();
//		
//		return leadService.salvar(lead);
//		
//    }
	
//	@GetMapping()
//	public ResponseEntity<RestPageImpl<Imobiliaria>> listar(Pageable pageable) {
//		
//		RestPageImpl<Imobiliaria> pageImobiliaria = imobiliariaService.listar(
//				(Pageable) pageable);
//		return ResponseEntity.ok(pageImobiliaria);
//	}
	
//	@GetMapping()
//	public ResponseEntity<RestPageImpl<Mensagem>> listar(Pageable pageable) {
//		
//		RestPageImpl<Mensagem> pageMensagem = mensagemService.listarMensagensImobiliaria(
//				(Pageable) pageable, "15439441");
//		return ResponseEntity.ok(pageMensagem);
//	}

}
