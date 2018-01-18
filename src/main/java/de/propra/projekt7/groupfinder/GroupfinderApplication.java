package de.propra.projekt7.groupfinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import de.propra.projekt7.repositories.ProfileRepository;
import entities.Profile;

@SpringBootApplication
@ComponentScan({"de.propra.projekt7.groupfinder"})
@EntityScan("de.propra.projekt7.entities")
@EnableJpaRepositories("de.propra.projekt7.repositories")
public class GroupfinderApplication implements CommandLineRunner{
	
	@Autowired
	ProfileRepository pRepo;

	public static void main(String[] args) {
		SpringApplication.run(GroupfinderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		Profile p1 = new Profile("XPeteX", "helloworld", "Peter", "Pan");
		pRepo.save(p1);
		p1.setUsername("XLogX");
		pRepo.save(p1);
		
		// Getting all Students
		System.out.println("***** All Students *******");
		for(Profile p : pRepo.findAll())
		{
			System.out.println(p);
		}
    
		// Getting the student with id 2
		System.out.println("***** Student with ID 2 *******");
		for(Profile p: pRepo.findById("XPeteX"))
		{
			System.out.println(p);
		}
	}
}
