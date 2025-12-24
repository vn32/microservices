package com.vn32.accounts;

import com.vn32.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//enabling auditor for update and create operation
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
//API Documentation
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts microservice REST API Documentation",
                description = "EazyBank Accounts microservice REST API Documentation",
                version = "v1",
                contact = @Contact( //any user will contact or ask the queries to below details
                        name = "Vikas Nishad",
                        email = "developer@vnbank.com",
                        url = "https://www.vnbank.com"
                ),
                license = @License( //it's open source or licensed
                        name = "Apache 2.0",
                        url = "https://www.vnbank.com"
                )
        ),
        externalDocs = @ExternalDocumentation( //more external sources to get more info on this microservices
                description =  "VNBank Accounts microservice REST API Documentation",
                url = "https://www.vnbankcom/swagger-ui.html"
        )
)
/*@ComponentScans({ @ComponentScan("com.eazybytes.accounts.controller") })
@EnableJpaRepositories("com.eazybytes.accounts.repository")
@EntityScan("com.eazybytes.accounts.model")
//above annotation use only if you have added controller and entity in different packages, just tell spring boot to sacn this, or else it will take this package as default and scan it's subpackages
*/
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
