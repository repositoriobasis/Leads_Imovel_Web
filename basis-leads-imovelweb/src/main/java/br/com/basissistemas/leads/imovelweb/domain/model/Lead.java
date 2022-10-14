package br.com.basissistemas.leads.imovelweb.domain.model;

import java.time.LocalDateTime;

import org.springframework.lang.NonNull;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Lead {
	
	private Integer idBancoDeDados;
	private String imovelContato;
    
	@NonNull
    private String nomeContato;
    @NonNull
    private String emailContato;
    
    private String telefoneContato;
    @NonNull
    private String mensagemContato;
    @NonNull
    private LocalDateTime dataLeadPortal;
    @NonNull
    private String idLeadPortal;
    @NonNull
    private String identificador;
    
}
