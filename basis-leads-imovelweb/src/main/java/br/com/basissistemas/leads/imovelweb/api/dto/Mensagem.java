package br.com.basissistemas.leads.imovelweb.api.dto;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Mensagem {

	private Long idAvisoNavplat;
	private String codigoAviso;  
	private Long idMensaje;
	private Timestamp fecha; // yyyy-MM-dd'T'HH:mm:ss.SSSZ
	private String nombre;
	private String email;
	private String telefono;
	private String textoMensaje;
	private Long idContacto;
	private Long idContactoAccion;
	private Long id; 
	
}
