package com.fooddhaba.foodmarket.service;

import java.util.HashMap;
import java.util.List;

import com.fooddhaba.foodmarket.model.LoginResponse;
import com.fooddhaba.foodmarket.model.Response;
import com.fooddhaba.foodmarket.model.User;

public interface IUserService {


	LoginResponse userLogin(User user);

	int getUserID(User user);

	Response userRegistration(User user);

	List<User> getUserDetail(User user);	

	

}
