package br.com.basissistemas.leads.imovelweb.api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Imobiliaria {
	
	private String codigoInmobiliaria;
	private Long idNavplat;
	private String nombre;
	private String habilitadoDesde;
	private Boolean bloqueada;
	private EmailsPorRol emailsPorRol;

}
