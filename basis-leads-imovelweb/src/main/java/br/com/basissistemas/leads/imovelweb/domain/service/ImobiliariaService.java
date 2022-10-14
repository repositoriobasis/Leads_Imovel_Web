package br.com.basissistemas.leads.imovelweb.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.basissistemas.leads.imovelweb.api.dto.Imobiliaria;
import br.com.basissistemas.leads.imovelweb.core.RestPageImpl;
import reactor.core.publisher.Mono;

@Service
public class ImobiliariaService {

	@Autowired
	WebClient iwClient;
	
	@Value("${imovelweb.api.protocolo}")
	private String protocolo;
	
	@Value("${imovelweb.api.host}")
	private String host;
	
//	public RestPageImpl<Imobiliaria> listar(Pageable pageable) {
	public RestPageImpl<Imobiliaria> listar() {
		Mono<RestPageImpl<Imobiliaria>> monoImobiliarias =  this.iwClient
				.get()
				.uri(uriBuilder -> uriBuilder.scheme(protocolo).host(host)
						.replacePath("/v1/imobiliarias")
						.build())
				.retrieve()
				.bodyToMono(new ParameterizedTypeReference<RestPageImpl<Imobiliaria>>() {});
		
		RestPageImpl<Imobiliaria> pageImobiliaria = monoImobiliarias.block();
		
		return pageImobiliaria;
	}
		
}
