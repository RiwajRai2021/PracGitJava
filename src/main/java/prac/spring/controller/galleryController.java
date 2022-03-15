package prac.spring.controller;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class galleryController {
	
	@GetMapping("/gallery")
	public String gallery(Model model){
		
		File imgDir = new File ("src/main/resources/static/imgs");
		String [] imgNameList = imgDir.list();
		
		model.addAttribute("imgNameList", imgNameList);
	
		return "galleryForm";
		
	}
			

}
