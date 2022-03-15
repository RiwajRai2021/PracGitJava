package prac.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import prac.spring.model.User;
import prac.spring.repository.UserRepository;

@Controller
public class userController {
	
	@Autowired
	private UserRepository userRepo;

	@GetMapping({"/","/login"})
	public String loginForm() {
		
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String userLogin(@ModelAttribute User user, Model model, HttpSession session) {
		
		User ur = userRepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		if (ur!=null) {
			
			session.setAttribute("cuser", ur.getFname());
			session.setMaxInactiveInterval(120);
			
			model.addAttribute("uname", ur.getFname());
			
			return "home"; 
			
		}
		
		model.addAttribute("error","user not found");
		return "loginForm";
	}
	 
	@GetMapping("/signup")
	public String signupForm() {
		
		return "signup";
	}
	
	@PostMapping("/signup")
	public String saveUser(@ModelAttribute User user) {
		
		userRepo.save(user);
		
		return "loginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		return "loginForm";
		
	}
}
