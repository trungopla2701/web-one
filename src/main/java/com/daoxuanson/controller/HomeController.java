package com.daoxuanson.controller;

import com.daoxuanson.entity.Role;
import com.daoxuanson.entity.User;
import com.daoxuanson.model.request.Register;
import com.daoxuanson.model.request.UserRequest;
import com.daoxuanson.service.RoleService;
import com.daoxuanson.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller

public class HomeController {
		@Autowired
		private RoleService roleService;
		@Autowired
		private UserService userService;

		@GetMapping("/admin/home")
		public ModelAndView home(@RequestParam(name = "userName", required = false)String userName
//                             @RequestParam(name = "passWord", required = false)String passWord
		) {

			ModelAndView mav = new ModelAndView("home");

			return mav;
		}


		@RequestMapping(value = "/home", method = RequestMethod.POST)
		public String homePost(@ModelAttribute(name = "register") Register register) {
			User user = userService.findUserByUserNameAndPassword(register.getUsername(),register.getPassword());
			String targerUrl="";
			if(user!=null)
			{
				for (Role role : user.getRoles()){
					if("2".equals(role.getName())){
						targerUrl="redirect:/admin/home";
						break;
					}
					else if("1".equals(role.getName())){
						targerUrl="redirect:/web";
						break;
					}
				}
			}
			else
			{
				// chưa có tài khoản sangtrang đăng ký
				targerUrl="redirect:/toEnrol";
			}
			return targerUrl;
		}
	@RequestMapping(value = "/toEnrol", method = RequestMethod.POST)
	public String LogintUser(@ModelAttribute(name = "register")Register register) {
		UserRequest userRequest = new UserRequest();
			userRequest.setUserName(register.getUsername());
			userRequest.setPassword(register.getPassword());
			List<Long> ids = new ArrayList();
			ids.add(2l);
			userRequest.setIds(ids);
			userService.insert(userRequest);
			return "redirect:/table";

	}

	@RequestMapping(value="/table")
	public ModelAndView table() {
			ModelAndView mav= new ModelAndView( );
			User user = new User();
			List<User> table= userService.findAll();
			mav.addObject("tables",table);
			return mav;
	}

		@GetMapping("/web")
		public ModelAndView web() {
			ModelAndView mav = new ModelAndView("web");

			return mav;
		}

		@GetMapping("/login")
		public ModelAndView login() {
			return new ModelAndView("login");
		}
		@GetMapping("/toEnrol")
		public ModelAndView ToEnrol() {
			return new ModelAndView("toEnrol");
		}

		// đăng ký
}
