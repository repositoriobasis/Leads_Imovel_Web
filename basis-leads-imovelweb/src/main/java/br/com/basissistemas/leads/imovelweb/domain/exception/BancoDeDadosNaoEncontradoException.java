package br.com.basissistemas.leads.imovelweb.domain.exception;

public class BancoDeDadosNaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BancoDeDadosNaoEncontradoException(String mensagem) {
		super(mensagem);
	}
	
	public BancoDeDadosNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}
