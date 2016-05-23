package com.devyul.datasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
/**main*/
@SpringBootApplication
public class DatasourceApplication  extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DatasourceApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DatasourceApplication.class, args);
	}
}
