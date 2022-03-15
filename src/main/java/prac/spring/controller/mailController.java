package prac.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import prac.spring.utilities.EmailUtils;

public class mailController {
	
	@GetMapping("/contact")
	public String emailForm() {
		
		return "email";
	}

	
	@PostMapping("/contact")
	public String sendEmail(HttpServletRequest request) {
	
		String to = request.getParameter("to");
		String subject = request.getParameter("subject");
		String message = request.getParameter("mesg");
		
		EmailUtils.sendEmail(to, subject, message);
		
		return "email";
		
	}
}
