package prac.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prac.spring.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	public void deleteEmploee(int id) {
		
		employeeRepository.deleteById(id);
	}
	
}
