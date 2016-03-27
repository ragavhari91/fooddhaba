package com.fooddhaba.foodmarket.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fooddhaba.foodmarket.model.LoginResponse;
import com.fooddhaba.foodmarket.model.Menu;
import com.fooddhaba.foodmarket.model.Response;
import com.fooddhaba.foodmarket.model.Responsibility;
import com.fooddhaba.foodmarket.model.User;
import com.fooddhaba.foodmarket.service.IUserService;
import com.mysql.jdbc.log.Log;



@RequestMapping("/user")
@RestController
public class UserController
{
	@Autowired
	private IUserService iuserservice;
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	@ResponseBody
	public LoginResponse userLogin(@RequestBody User user) 
	{
		return iuserservice.userLogin(user);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	@ResponseBody
	public Response userRegistration(@RequestBody User user) 
	{
		Response response = iuserservice.userRegistration(user);
		return response;
	}
}
