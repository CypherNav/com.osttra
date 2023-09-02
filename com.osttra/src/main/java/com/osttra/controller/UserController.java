package com.osttra.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.osttra.service.UserService;
import com.osttra.to.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@Controller
public class UserController {
		@Autowired
		UserService userservice;
		
		@PostMapping("/register")
		public String register(User user) {
			userservice.register(user);
			return "index";
		}
		
		@PostMapping("/login")
		public ModelAndView login(String username,String password,HttpServletRequest request) {
			ModelAndView modelandview = null;
			User user = userservice.login(username,password);
			System.out.println(username+password);
			if(user!=null) {
				modelandview=new ModelAndView("welcome_page");
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				List<User> users = userservice.getUsers();
				List<User> students = userservice.getStudents();
				if(user.getRole().equalsIgnoreCase("admin")) {
					modelandview.addObject("users",users);
				}else if(user.getRole().equalsIgnoreCase("teacher")) {
					modelandview.addObject("students",students);
				}
			}else {
				modelandview = new ModelAndView("index");
				modelandview.addObject("errorMessage","Wrong Creditals!!!");
			}
			return modelandview;
		}
		@GetMapping("updatePage/{username}")
		public ModelAndView updatePage(@PathVariable String username,HttpServletRequest request) {
			HttpSession session = request.getSession(false);
			ModelAndView model = null;
			if(session!=null) {
				model=new ModelAndView("update_user");
				model.addObject("updatinguser",userservice.getUser(username));
			}else {
				model = new ModelAndView("index");
			}
			return model;
		}
		@PostMapping("update")
		public ModelAndView update(User user,HttpServletRequest request) {
			ModelAndView model=null;
			userservice.update(user);
			HttpSession session= request.getSession(false);
			User curruser = (User) session.getAttribute("user");
			String password = curruser.getPassword();
			String role = curruser.getRole();
			String status=curruser.getStatus();
			user.setPassword(password);
			user.setRole(role);
			user.setStatus(status);
			session.setAttribute("user", user);
			model=new ModelAndView("welcome_page");
			List<User> users = userservice.getUsers();
			List<User> students = userservice.getStudents();
			if(user.getRole().equalsIgnoreCase("admin")) {
				model.addObject("users",users);
			}else if(user.getRole().equalsIgnoreCase("teacher")) {
				model.addObject("students",students);
			}
			model.addObject("updateMsg", "Profile updated successfully");
			return model;
		}
		@GetMapping("delete/{username}")
		public ModelAndView delete(@PathVariable String username,HttpServletRequest request) {
			ModelAndView modelandview =null;
			HttpSession session = request.getSession(false);
			if(session!=null) {
				userservice.delete(username);
				if (((User) session.getAttribute("user")).getRole().equals("Admin")) {

					modelandview = new ModelAndView("welcome_page");
					List<User> users = userservice.getUsers();
					modelandview.addObject("users", users);
				} else {
					modelandview = new ModelAndView("index");
					modelandview.addObject("deleteSucessMsg", "Your Account has been deleted successfully..");
				}
			}else {
				modelandview = new ModelAndView("index");
			}
			return modelandview;
			
		}
		@GetMapping("/logout")
		public ModelAndView logout(HttpServletRequest request) {

			ModelAndView modelAndView =  new ModelAndView("index");

			HttpSession session = request.getSession(false);
			System.out.println("Session is while logout "+session);

			if (session != null) {

				session.invalidate();
				
				modelAndView.addObject("logoutMessage", "Logged-out successfully..");
			} else {

				modelAndView.addObject("errorMessage", "You are not logged in!!");
			}

			return modelAndView;
		}
		@GetMapping("allow/{username}")
		public ModelAndView allow(@PathVariable String username,HttpServletRequest request) {
			ModelAndView modelandview = null;
			HttpSession session = request.getSession(false);
			if(session!=null) {
				userservice.allow(username);
				modelandview = new ModelAndView("welcome_page");
				List<User> users = userservice.getUsers();
				modelandview.addObject("users", users);
				
			}else {
				modelandview = new ModelAndView("index");
			}
			return modelandview;
		}
		@GetMapping("block/{username}")
		public ModelAndView block(@PathVariable String username,HttpServletRequest request) {
			ModelAndView modelandview = null;
			HttpSession session = request.getSession(false);
			if(session!=null) {
				userservice.block(username);
				modelandview = new ModelAndView("welcome_page");
				List<User> users = userservice.getUsers();
				modelandview.addObject("users", users);
				
			}else {
				modelandview = new ModelAndView("index");
			}
			return modelandview;
		}
}



















