package br.com.basissistemas.leads.imovelweb.core.client;

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
	
	@Bean("leadClient")
	public WebClient webClientBasisLead(WebClient.Builder builder) {
		String basicToken = "Basic YmFzaXNfbGVhZHM6JDJhJDEyJGo4RFhoZ0liNU12ZnhGZ01MZGd5Vy5FRUguQmZVR0Ryb0Z5VUZWN2FNeGZFVy5nbVVRcXhx";
		String urlApi = protocoloApi.concat("://").concat(hostApi).concat(":").concat(portaApi);
		
		return builder
				.baseUrl(urlApi)
				.defaultHeader("Authorization", basicToken)
				.build();
	}
	
}
