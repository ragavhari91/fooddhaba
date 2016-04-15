package com.fooddhaba.foodmarket.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.fooddhaba.foodmarket.config.HibernateConfig;
import com.fooddhaba.foodmarket.model.Menu;
import com.fooddhaba.foodmarket.model.Response;
import com.fooddhaba.foodmarket.model.Responsibility;
import com.fooddhaba.foodmarket.model.User;
import com.fooddhaba.foodmarket.model.UserSession;



@Repository
public class UserDAOImpl implements IUserDAO 
{
	
	@SuppressWarnings("unused")
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean userLogin(User user) 
	{
		String user_email = user.getEmail_address();
		String user_password = user.getPassword();
		
		boolean result = false;
		
		Session session = HibernateConfig.getSessionFactory().openSession();
		session.beginTransaction();
		
		org.hibernate.Query query = session.createQuery("select count(user.id) from User user where user.email_address = :email and user.password = :password");
		query.setParameter("email", user_email);
		query.setParameter("password", user_password);
		
		Long count = (Long) query.uniqueResult();
		
	
		session.getTransaction().commit();
        session.close();
        
    	if(count > 0)
		{
			result = true;
		}
		else
		{
			result = false;
		}
		
		return result;
	}

	@Override
	public int getUserID(User user) 
	{
		Session session = HibernateConfig.getSessionFactory().openSession();
		session.beginTransaction();
		
		org.hibernate.Query query = session.createQuery("select user.id from User user where user.email_address = :email");
		query.setParameter("email", user.getEmail_address());
		
		int userid = (Integer) query.uniqueResult();
		
		session.getTransaction().commit();
        session.close();
        
		return userid;
	}

	
	private boolean UserAlreadyExists(User user)
	{
		Session session = HibernateConfig.getSessionFactory().openSession();
		session.beginTransaction();
		
		boolean result =  session.createQuery("from User user where user.email_address = :emailAddress")
				.setParameter("emailAddress", user.getEmail_address())
				.uniqueResult() != null;
		
		session.getTransaction().commit();
        session.close();
        
        return result;
	}
	
	@Override
	public Response userRegistration(User user) 
	{
		Session session = HibernateConfig.getSessionFactory().openSession();
		session.beginTransaction();
		
		Response response = new Response();
		
		// check if user already exists
		if(!UserAlreadyExists(user))
		{
			// other lookup fields
			user.setCity_id(1);
			user.setState_id(1);
			user.setCountry_id(1);
			user.setFdrole_id(5);
			user.setStatus_id(1);
			user.setGender_id(1);
			
			
			try
			{
				if(session.save(user) != null)
				{
					response.setStatus("success");
					response.setMessage("Successfully Added");
				}
				else
				{
					response.setStatus("failure");
					response.setMessage("Error");
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception : "+e.getMessage());
			}

		}
		else
		{
			response.setStatus("Failure");
			response.setMessage("User Already Exists");
		}
		
				
		session.getTransaction().commit();
        session.close();

		
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserDetail(User user)
	{
		 
		Session session = HibernateConfig.getSessionFactory().openSession();
		session.beginTransaction();
		List<User> userDetail = null;

		org.hibernate.Query query = session.createQuery("from User user where user.email_address = :userEmailID");
		query.setParameter("userEmailID", user.getEmail_address());
		userDetail = query.list();

		session.getTransaction().commit();
        session.close();

		return userDetail;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Responsibility> getUserResponsibilities(User user) 
	{
		Session session = HibernateConfig.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<Responsibility> responsibilities  = null;

		int userID = getUserID(user);
		
		String query = "SELECT resp.* FROM Responsibility resp join FD_ROLE_RESPONSIBILITY_MAPPING fdrrm on resp.id = fdrrm.responsibility_id join User u on u.fd_role_id = fdrrm.role_id where u.id = :userid group by resp.id";

		//Criteria criteria = session.createCriteria(Responsibility.class,"resp");
		//criteria.createAlias("resp.id", arg1)
		
		SQLQuery sqlQuery = session.createSQLQuery(query);
		sqlQuery.setParameter("userid", userID);
		sqlQuery.addEntity(Responsibility.class);
		responsibilities = sqlQuery.list();
		
		session.getTransaction().commit();
        session.close();
		return responsibilities;
	}
	
	
    @SuppressWarnings("unchecked")
	public List<Menu> getUserMenus(User user)
    {
    	Session session = HibernateConfig.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<Menu> menus = null;
		int userID = getUserID(user);
		
		String query = "select m.* from menu m join responsibility_menu_mapping respmenu on m.id = respmenu.responsibility_id "
				+ "join fd_role_responsibility_mapping frrm on frrm.responsibility_id = respmenu.responsibility_id "
				+ "join user u on u.fd_role_id = frrm.role_id where u.id = :userID group by m.id";
		
		SQLQuery sqlQuery = session.createSQLQuery(query);
		sqlQuery.setParameter("userID", userID);
		sqlQuery.addEntity(Menu.class);
		menus = sqlQuery.list();
		
		session.getTransaction().commit();
        session.close();
        
        return menus;
    }

	@Override
	public List<UserSession> createUserSession(User user) 
	{
		Session session = HibernateConfig.getSessionFactory().openSession();
		session.beginTransaction();
		
		List<UserSession> userSessions = new ArrayList<UserSession>();
		
		int userID = getUserID(user);
		String token = UUID.randomUUID().toString() + userID;
		
		UserSession userSession = new UserSession();
		userSession.setUser_id(userID);
		userSession.setToken(token);
		userSession.setStatus_id(1);

		
		try
		{
			if(session.save(userSession) != null)
			{
				userSessions.add(userSession);
			}
			else
			{
				userSessions = null;
			}
		}
		catch(Exception e)
		{
			userSessions = null;
			System.out.println("Exception : "+e.getStackTrace());
		}
		
		
		session.getTransaction().commit();
        session.close();
		return userSessions;
	}


    

}
