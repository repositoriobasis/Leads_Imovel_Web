package br.com.basissistemas.leads.imovelweb.core.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ImovelwebClient {

	@Value("${imovelweb.api.host}")
	private String hostApi;
	
	@Bean("iwClient")
	public WebClient webClientImovelweb(WebClient.Builder builder) {
		String bearerToken = "Bearer c25d61d2-de70-44b7-b111-2a25c94c75fd";
		
		return builder
				.baseUrl(hostApi)
				.defaultHeader("Authorization", bearerToken)
				.build();
	}
	
}
