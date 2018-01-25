package de.propra.projekt7.groupfinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"de.propra.projekt7.groupfinder"})
@EntityScan("entities")
@EnableJpaRepositories("de.propra.projekt7.repositories")
public class GroupfinderApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(GroupfinderApplication.class, args);
	}
}
