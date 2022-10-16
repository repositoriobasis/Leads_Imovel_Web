package br.com.basissistemas.leads.imovelweb.core.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ImovelwebClient {

	@Value("${imovelweb.api.host}")
	private String hostApi;
	
	@Value("${imovelweb.api.token}")
	private String tokenApi;
	
	@Bean("iwClient")
	public WebClient webClientImovelweb(WebClient.Builder builder) {
		String bearerToken = "Bearer " + tokenApi;
		
		return builder
				.baseUrl(hostApi)
				.defaultHeader("Authorization", bearerToken)
				.build();
	}
	
}
