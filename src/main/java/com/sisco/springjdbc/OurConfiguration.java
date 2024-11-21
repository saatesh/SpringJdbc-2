package com.sisco.springjdbc;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.sisco.springjdbc")
public class OurConfiguration {
	
	@Bean
	DataSource dataSource() {
		//-----DataSource is not working....use DataSourceBuilder
		//DataSource properties=new DataSourceProperties();
		DataSourceBuilder<?> properties = DataSourceBuilder.create();
		properties.driverClassName("com.mysql.cj.jdbc.Driver");
		properties.url("jdbc:mysql://localhost:3306");
		properties.username("root");
		properties.password("root");
		
		return properties.build();
	}

}
