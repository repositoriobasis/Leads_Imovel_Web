package br.com.basissistemas.leads.imovelweb.domain.service;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.basissistemas.leads.imovelweb.domain.model.LeadPortal;
import reactor.core.publisher.Mono;

@Service
public class LeadPortalService {
	
	@Autowired
	WebClient leadClient;
	
	@Value("${basis.lead.api.protocolo}")
	private String protocoloApi;
	
	@Value("${basis.lead.api.host}")
	private String hostApi;
	
	@Value("${basis.lead.api.porta}")
	private String portaApi;
	
	public LeadPortal buscar(String codigoCliente) {
		Mono<LeadPortal> monoLeadPortal =  this.leadClient
				.get()
				.uri(uriBuilder -> uriBuilder.scheme(protocoloApi).host(hostApi).port(portaApi)
						.replacePath("/leadPortais/" + codigoCliente)
						.build())
				.retrieve()
				.onStatus(httpStatus -> HttpStatus.NOT_FOUND.equals(httpStatus),
	                    clientResponse -> Mono.error(new EntityNotFoundException(String.format("Não existe cadastro de lead portal para o cliente %s", codigoCliente))))
				.bodyToMono(LeadPortal.class);
		
		LeadPortal leadPortal = monoLeadPortal.block();
		
		return leadPortal;
	}

}
