package com.fooddhaba.foodmarket.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fooddhaba.foodmarket.config.HibernateConfig;
import com.fooddhaba.foodmarket.model.BusinessEnquiry;
import com.fooddhaba.foodmarket.model.BusinessType;
import com.fooddhaba.foodmarket.model.Response;

@Repository
public class EnquiryDAOImpl implements IEnquiryDAO 
{
	
	@SuppressWarnings("unused")
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Response businessEnquiry(BusinessEnquiry businessEnquiry) 
	{
		Session session = HibernateConfig.getSessionFactory().openSession();
		session.beginTransaction();
		
		Response response = new Response();
		
		if(session.save(businessEnquiry) != null)
		{
			response.setStatus("Success");
			response.setMessage("Your enquiry has been submitted and out team will contact you soon.Thank you");
		}
		else
		{
			response.setStatus("Failure");
			response.setMessage("Failed to submit your enquiry,please try again");
		}
		
		
		session.getTransaction().commit();
        session.close();
		return response;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusinessType> businessEnquiryInitialData() 
	{
		Session session = HibernateConfig.getSessionFactory().openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(BusinessType.class).add(Restrictions.eq("status_id", 1));
		List<BusinessType> businessTypes = new ArrayList<BusinessType>();
		
		businessTypes = criteria.list();
		
		session.getTransaction().commit();
        session.close();
        
		return businessTypes;
	}

}
