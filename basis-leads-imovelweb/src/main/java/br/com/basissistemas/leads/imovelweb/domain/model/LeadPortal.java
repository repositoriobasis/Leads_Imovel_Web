package br.com.basissistemas.leads.imovelweb.domain.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LeadPortal {
	
	private Integer id;
	private Integer idBancoDeDados;
	private Integer idPortal;
	private String bancoNome;
	private String nomePortal;
	private String codigoCliente;
	
}
