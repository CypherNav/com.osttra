package com.osttra.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osttra.Repository.UserRepository;
import com.osttra.to.User;

@Service
public class UserService {
	@Autowired
	UserRepository repo;
	public void register(User user) {
		repo.add(user);  
	}
	
	public User login(String username,String password) {
		return repo.getUser(username,password);
	}

	public List<User> getUsers(){
		
		return repo.getUsers();
	}
	public List<User> getStudents(){
		return repo.getStudents();
	}
	public User getUser(String Username) {
		return repo.getUser(Username);
	}
	public void update(User user) {
		repo.update(user);
	}
	public void delete(String username) {
		repo.delete(username);
	}

	public void allow(String username) {
		repo.allow(username);
		
	}
	public void block(String username) {
		repo.block(username);
	}
}
