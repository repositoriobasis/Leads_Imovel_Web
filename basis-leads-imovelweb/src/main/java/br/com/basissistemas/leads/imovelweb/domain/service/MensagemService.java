package br.com.basissistemas.leads.imovelweb.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.basissistemas.leads.imovelweb.api.dto.Mensagem;
import br.com.basissistemas.leads.imovelweb.core.RestPageImpl;
import reactor.core.publisher.Mono;

@Service
public class MensagemService {

	@Autowired
	WebClient iwClient;
	
	@Value("${imovelweb.api.protocolo}")
	private String protocolo;
	
	@Value("${imovelweb.api.host}")
	private String host;
	
//	public RestPageImpl<Mensagem> listarMensagensImobiliaria(Pageable pageable, String codigoImobiliaria) {
	public RestPageImpl<Mensagem> listarMensagensImobiliaria(String codigoImobiliaria) {
		Mono<RestPageImpl<Mensagem>> monoMensagens =  this.iwClient
				.get()
				.uri(uriBuilder -> uriBuilder.scheme(protocolo).host(host)
						.replacePath("/v1/imobiliarias/" + codigoImobiliaria + "/mensagens")
						.build())
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<RestPageImpl<Mensagem>>() {});
		
		RestPageImpl<Mensagem> pageMensagens = monoMensagens.block();
		
		return pageMensagens;
	}
		
}
