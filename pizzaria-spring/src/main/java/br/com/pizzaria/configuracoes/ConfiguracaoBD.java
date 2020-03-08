package br.com.pizzaria.configuracoes;

import java.beans.PropertyVetoException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "br.com.pizzaria.modelo.repositorios")
public class ConfiguracaoBD {

	@Bean
	public DataSources dataSource() throws IllegalStateException, PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/pizzaria");
		dataSource.setUser("root");
		dataSource.setPassword("123456");
		return dataSource();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() throws Exception {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		return entityManagerFactoryBean;

	}

}
