package br.com.basissistemas.leads.imovelweb.api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Imovelweb {

	private Integer idAvisoNavplat;
	private String codigoAviso;  
	private Integer idMensaje;
	private String fecha; // yyyy-MM-dd'T'HH:mm:ss.SSSZ
	private String nombre;
	private String email;
	private String telefono;
	private String textoMensaje;
	private Integer idContacto;
	private Integer idContactoAccion;
	private Integer id; 
	
}
