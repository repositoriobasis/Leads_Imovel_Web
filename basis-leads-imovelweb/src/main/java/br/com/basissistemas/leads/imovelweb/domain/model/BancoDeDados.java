package br.com.basissistemas.leads.imovelweb.domain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name = "webbasis.tbg_banco_de_dados")
public class BancoDeDados {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer idEmpresa;
	
	private String nome;
	private String bancoNome;
	private String bancoHost;
	private String bancoUsuario;
	private String bancoSenha;
	private String bancoPorta;
	private String codigo;
	
	private Date dataCadastro;
	
}
