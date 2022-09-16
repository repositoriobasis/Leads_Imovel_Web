package br.com.basissistemas.leads.imovelweb.core.hibernate;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.MultiTenancyStrategy;
import org.hibernate.cfg.Environment;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class HibernateConfig {
	
	@Autowired
	private JpaProperties jpaProperties;
	
	@Value("${spring.jpa.show-sql}")
	private Boolean showSQL;
	
	@Value("${spring.jpa.properties.hibernate.format_sql}")
	private Boolean formatSQL;

	@Bean
	JpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}
	
	@Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(
    		HikariDataSource dataSource,
            MultiTenantConnectionProvider multiTenantConnectionProviderImpl,
            CurrentTenantIdentifierResolver currentTenantIdentifierResolverImpl
    ) {

        Map<String, Object> jpaPropertiesMap = new HashMap<>(jpaProperties.getProperties());
        jpaPropertiesMap.put(Environment.MULTI_TENANT, MultiTenancyStrategy.DATABASE);
        jpaPropertiesMap.put(Environment.MULTI_TENANT_CONNECTION_PROVIDER, multiTenantConnectionProviderImpl);
        jpaPropertiesMap.put(Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, currentTenantIdentifierResolverImpl);
        jpaPropertiesMap.put(Environment.FORMAT_SQL, formatSQL);
        jpaPropertiesMap.put(Environment.SHOW_SQL, showSQL);
        jpaPropertiesMap.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57Dialect");
//        jpaPropertiesMap.put(Environment.size, 5);

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("br.com.basissistemas*");
        em.setJpaVendorAdapter(this.jpaVendorAdapter());
        em.setJpaPropertyMap(jpaPropertiesMap);
        return em;
    }

}
