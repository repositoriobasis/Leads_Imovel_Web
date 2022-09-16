package br.com.basissistemas.leads.imovelweb.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.sun.istack.NotNull;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "cnt_cliente_site")
public class Lead {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private Integer idBancoDeDados; 
	
	@CreationTimestamp	
	private Date dataCadastro; 
	
	@UpdateTimestamp
	private Date dataAtualizacao;  
	
	private Date dataExclusao;
	
	private String usuarioCadastrou;
	
	private String usuarioAtualizou;
	
	private String usuarioExcluiu;
	
	private String nomeContato;
	private String emailContato;
	private String telefoneContato;
	private String mensagemContato;
	private String imovelContato;
	private Integer idFac;
	private String identificador;

}
