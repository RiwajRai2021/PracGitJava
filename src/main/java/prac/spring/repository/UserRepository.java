package prac.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import prac.spring.model.User;

public interface UserRepository extends  JpaRepository<User, Integer>{
	
	User findByUsernameAndPassword(String un, String psw);
	

}
