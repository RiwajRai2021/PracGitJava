package prac.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import prac.spring.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer > {

}
