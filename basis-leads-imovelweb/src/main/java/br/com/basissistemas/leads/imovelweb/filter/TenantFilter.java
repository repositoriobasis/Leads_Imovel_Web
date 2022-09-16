package br.com.basissistemas.leads.imovelweb.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.basissistemas.leads.imovelweb.core.multitenant.TenantContext;

public class TenantFilter extends OncePerRequestFilter {
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		 String requestUrl = request.getRequestURL().toString();
		 
		 String schemaName = requestUrl.substring((requestUrl.lastIndexOf("/")+1), requestUrl.length());
		 
		 if (schemaName != null) {
	            String tenantSchemaName = "wb".concat(schemaName);
	            if(StringUtils.hasText(schemaName)) {
	            	TenantContext.setCurrentTenant(tenantSchemaName);
	            } else {
	                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
	                response.getWriter().write("Identificador do cliente não fornecido");
	                response.getWriter().flush();
	                return;
	            }
	        }
	    
	        filterChain.doFilter(request, response);
		
	}
	
	public static String Right(String text, int length) {
        if (text.length() <= length) return null;
        return text.substring(text.length() - length);
    }

}
