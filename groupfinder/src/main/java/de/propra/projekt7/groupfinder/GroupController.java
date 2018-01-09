package de.propra.projekt7.groupfinder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GroupController {
	
	@GetMapping(path="/")
	public String login() {
		return "login";
	}
	
	@GetMapping(path="/register")
	public String register() {
		return "register";
	}
	
	@PostMapping(path="register")
	public String registerPost() {
		
		return "login";
	}
}
