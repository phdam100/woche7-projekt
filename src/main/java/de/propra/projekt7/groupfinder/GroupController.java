package de.propra.projekt7.groupfinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import de.propra.projekt7.repositories.ProfileRepository;
import entities.Profile;

@Controller
public class GroupController {
	
	@Autowired
	ProfileRepository pRepo;
	
	@GetMapping(path="/")
	public String login() {
		return "login";
	}
	
	@GetMapping(path="/register")
	public String register() {
		return "register";
	}
	
	@PostMapping(path="/register")
	public String registerPost() {
		Profile p1 = new Profile("XPeteX", "helloworld", "Peter", "Pan");
		Profile p2 = new Profile("hhaha", "test", "rep", "rep");
		pRepo.save(p1);
		pRepo.save(p2);
		
		// Getting all Students
		System.out.println("***** All Students *******");
		for(Profile p : pRepo.findAll())
		{
			System.out.println(p);
		}
    
		// Getting the student with id 2
		System.out.println("***** Student with ID 2 *******");
		for(Profile p: pRepo.findByUsername("XPeteX"))
		{
			System.out.println(p);
		}
		
		// Getting the student with id 2
				System.out.println("***** Student with ID 2 *******");
				for(Profile p: pRepo.findByUsername("hhaha"))
				{
					System.out.println(p);
				}
		return "login";
	}
}
