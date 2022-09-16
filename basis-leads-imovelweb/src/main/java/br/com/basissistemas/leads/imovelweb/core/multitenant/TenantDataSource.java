package br.com.basissistemas.leads.imovelweb.core.multitenant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import br.com.basissistemas.leads.imovelweb.domain.model.BancoDeDados;
import br.com.basissistemas.leads.imovelweb.domain.repository.BancoDeDadosRepository;

@Component
public class TenantDataSource {
	
	@Autowired
	BancoDeDadosRepository bancoDeDadosRepository;
	
	private HashMap<String, DataSource> dataSources = new HashMap<>();
	
	private HikariDataSource createDataSource(BancoDeDados config) {
        if (config != null) {
        	HikariConfig hikari = new HikariConfig();
        	hikari.setMinimumIdle(2);
        	hikari.setMaximumPoolSize(5);
        	hikari.setJdbcUrl("jdbc:mysql://"
        			.concat(config.getBancoHost())
        			.concat(":")
        			.concat(config.getBancoPorta())
        			.concat("/")
        			.concat(config.getBancoNome())
        			.concat("?serverTimezone=UTC"));
        	hikari.setUsername(config.getBancoUsuario());
        	hikari.setPassword(config.getBancoSenha());
            
        	HikariDataSource ds = new HikariDataSource(hikari);
        	
        	return (HikariDataSource) ds;
        }
        return null;
    }
	
	public HikariDataSource getDataSource(BancoDeDados config) {
        if (dataSources.get(config.getBancoNome()) != null) {
            return (HikariDataSource) dataSources.get(config.getBancoNome());
        }
        HikariDataSource dataSource = createDataSource(config);
        if (dataSource != null) {
            dataSources.put(config.getBancoNome(), dataSource);
        }
        return dataSource;
    }
	
	public Map<String, HikariDataSource> getAll() {
        List<BancoDeDados> configList = bancoDeDadosRepository.findByBancoNomeIsNotNull();
        Map<String, HikariDataSource> result = new HashMap<>();
        for (BancoDeDados config : configList) {
        	HikariDataSource dataSource = getDataSource(config);
            result.put(config.getBancoNome(), dataSource);
        }
        return result;
    }
	
	

}
