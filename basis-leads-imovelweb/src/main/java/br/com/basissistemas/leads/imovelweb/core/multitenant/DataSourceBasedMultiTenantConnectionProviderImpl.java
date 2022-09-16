package br.com.basissistemas.leads.imovelweb.core.multitenant;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariDataSource;

@Component
public class DataSourceBasedMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

	private static final long serialVersionUID = 1L;

	@Autowired
    private ApplicationContext context;
	
	@Autowired
    private HikariDataSource defaultDS;
	
	String DEFAULT_TENANT_ID = "webbasis";
	
	 private Map<String, HikariDataSource> map = new HashMap<>();
	 
	 boolean init = false;
	 
	 @PostConstruct
	    public void load() {
	        map.put(DEFAULT_TENANT_ID, defaultDS);
	    }
	
	@Override
	protected DataSource selectAnyDataSource() {
		return map.get(DEFAULT_TENANT_ID);
	}

	@Override
	protected DataSource selectDataSource(String tenantIdentifier) {
		if (!init) {
            init = true;
            TenantDataSource tenantDataSource = context.getBean(TenantDataSource.class);
            map.putAll(tenantDataSource.getAll());
        }
        return map.get(tenantIdentifier) != null ? map.get(tenantIdentifier) : map.get(DEFAULT_TENANT_ID);
	}
	
	

}
