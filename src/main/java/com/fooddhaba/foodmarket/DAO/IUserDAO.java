package com.fooddhaba.foodmarket.DAO;

import java.util.List;

import com.fooddhaba.foodmarket.model.Menu;
import com.fooddhaba.foodmarket.model.Response;
import com.fooddhaba.foodmarket.model.Responsibility;
import com.fooddhaba.foodmarket.model.UserSession;
import com.fooddhaba.foodmarket.model.User;

public interface IUserDAO {

	boolean userLogin(User user);

	int getUserID(User user);

	Response userRegistration(User user);

	List<User> getUserDetail(User user);
	
	List<Responsibility> getUserResponsibilities(User user);

	List<Menu> getUserMenus(User user);

	List<UserSession> createUserSession(User user);


	

}
