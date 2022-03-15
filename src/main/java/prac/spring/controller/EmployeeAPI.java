package prac.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import prac.spring.model.Employee;
import prac.spring.repository.EmployeeRepository;

@RestController
@RequestMapping("/emp/rest/api")
public class EmployeeAPI {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@GetMapping("/list")
	public List<Employee> getAllEmp() {
		
		return empRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Employee> getOneEmp(@PathVariable int id) {
		
		return empRepo.findById(id);
	}
	
	@PostMapping("/add")
	public String addEmp(@RequestBody Employee emp) {
		
		empRepo.save(emp);
		
		return "added success";
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
	
		empRepo.deleteById(id);
		
		return "delete succcess";
		
	}

}
