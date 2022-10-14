package br.com.basissistemas.leads.imovelweb.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.basissistemas.leads.imovelweb.domain.model.Lead;
import reactor.core.publisher.Mono;

@Service
public class LeadService {
	
	@Autowired
	WebClient leadClient;
	
	@Value("${basis.lead.api.protocolo}")
	private String protocoloApi;
	
	@Value("${basis.lead.api.host}")
	private String hostApi;
	
	@Value("${basis.lead.api.porta}")
	private String portaApi;
	
	public Lead salvar(String schema, Lead lead) {
		System.out.println(schema + " - " + lead.toString());
		Mono<Lead> monoLead =  this.leadClient
				.post()
				.uri(uriBuilder -> uriBuilder.scheme(protocoloApi).host(hostApi).port(portaApi)
						.replacePath("/leads/" + schema)
						.build())
				.bodyValue(lead)
				.retrieve()
				.bodyToMono(Lead.class);
		
		return monoLead.block();
	}

}
