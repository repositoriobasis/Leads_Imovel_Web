package br.com.basissistemas.leads.imovelweb.core.client;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BasisLeadClient {

	@Value("${basis.lead.api.protocolo}")
	private String protocoloApi;
	
	@Value("${basis.lead.api.host}")
	private String hostApi;
	
	@Value("${basis.lead.api.porta}")
	private String portaApi;
	
	@Value("${basis.lead.api.username}")
	private String username;
	
	@Value("${basis.lead.api.password}")
	private String password;
	
	@Bean("leadClient")
	public WebClient webClientBasisLead(WebClient.Builder builder) {
		
		String auth = username + ":" + password;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String( encodedAuth );
        
		String urlApi = protocoloApi.concat("://").concat(hostApi).concat(":").concat(portaApi);
		
		return builder
				.baseUrl(urlApi)
				.defaultHeader("Authorization", authHeader)
				.build();
	}
	
}
