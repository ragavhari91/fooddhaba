package com.fooddhaba.foodmarket.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.fooddhaba.foodmarket.DAO.IUserDAO;
import com.fooddhaba.foodmarket.model.LoginResponse;
import com.fooddhaba.foodmarket.model.Menu;
import com.fooddhaba.foodmarket.model.Response;
import com.fooddhaba.foodmarket.model.Responsibility;
import com.fooddhaba.foodmarket.model.UserSession;
import com.fooddhaba.foodmarket.model.User;


@Service
@Transactional
public class UserServiceImpl implements IUserService 
{
	@Autowired
	private IUserDAO iuserdao;
	
	
	private Response checkUserCredentials(User user)
	{
		boolean loginresponse = iuserdao.userLogin(user);
		Response response = new Response();
		
		
		if(loginresponse)
		{
			response.setStatus("Success");
			response.setMessage("Login Success");
		}
		else
		{
			response.setStatus("Failure");
			response.setMessage("Username or password incorrect");
		}
		
		return response;
	}

	@Override
	public LoginResponse userLogin(User user) 
	{
		Response response = checkUserCredentials(user);
		
		List<User> userDetail = null;
		List<Responsibility> responsibilities = null;
		List<Menu> menus = null;
		List<UserSession> userSessions = null;
		
		if(response.getStatus() != "Failure")
		{
			userDetail = iuserdao.getUserDetail(user);
			responsibilities = iuserdao.getUserResponsibilities(user);
			menus = iuserdao.getUserMenus(user);
			userSessions = iuserdao.createUserSession(user);
		}
		
		LoginResponse loginResponse = new LoginResponse();
		
		loginResponse.setResponse(response);
		loginResponse.setUser(userDetail);
		loginResponse.setMenus(menus);
		loginResponse.setResponsibilities(responsibilities);
		loginResponse.setSession(userSessions);
		
		return loginResponse;
	}


	@Override
	public int getUserID(User user) 
	{
		int userid = iuserdao.getUserID(user);
		return userid;
	}

	@Override
	public Response userRegistration(User user) 
	{
		return iuserdao.userRegistration(user);
	
	}

	@Override
	public List<User> getUserDetail(User user) 
	{
		return iuserdao.getUserDetail(user);
	}

	

}
