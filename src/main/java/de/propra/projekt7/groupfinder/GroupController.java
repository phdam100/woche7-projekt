package de.propra.projekt7.groupfinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import de.propra.projekt7.repositories.ProfileRepository;
import entities.Profile;

@Controller
public class GroupController {
	
	@Autowired
	ProfileRepository pRepo;
	
	@GetMapping(path="/")
	public String login1() {
		return login2();
	}
	
	@GetMapping(path="/login")
	public String login2() {
		return "login";
	}
	
	@PostMapping(path="/")
	public RedirectView login1Post(Model m, @RequestParam String username, @RequestParam String password) {
		return login2Post(m, username, password);
	}
	
	@PostMapping(path="/login")
	public RedirectView login2Post(Model m, @RequestParam String username, @RequestParam String password) {
		
		Profile pLogin = pRepo.findByUsername(username);
		if(pLogin == null) {
			m.addAttribute("passwordUsernameExc", "Falscher Benutzername oder Passwort");
			return new RedirectView("http://localhost:8080/index");
		}
		if(!pLogin.getPassword().equals(password))
		{
			m.addAttribute("passwordUsernameExc", "Falscher Benutzername oder Passwort");
			return new RedirectView("http://localhost:8080/index");
		}
		
		return new RedirectView("http://localhost:8080/index");
	}
	
	@GetMapping(path="/register")
	public String register() {
		return "register";
	}
	
	@PostMapping(path="/register")
	public RedirectView registerPost(Model m, Profile p, @RequestParam String password1, @RequestParam String password2) {
		m.addAttribute("p", p);
		if(!password1.equals(password2)) {
			m.addAttribute("passwordExc", "Passwörter stimmen nicht überein!");
			return new RedirectView("http://localhost:8080/login");
		}
		if(password1.length()<4) {
			m.addAttribute("passwordExc", "Passwort sollte mindestens 4 Zeichen enthalten!");
			return new RedirectView("http://localhost:8080/login");
		}
		p.setPassword(password1);		
		pRepo.save(p);
		
		return new RedirectView("http://localhost:8080/login");
	}
}
