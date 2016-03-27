package com.fooddhaba.foodmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fooddhaba.foodmarket.DAO.IEnquiryDAO;
import com.fooddhaba.foodmarket.model.BusinessEnquiry;
import com.fooddhaba.foodmarket.model.BusinessType;
import com.fooddhaba.foodmarket.model.Response;


@Service
@Transactional
public class EnquiryServiceImpl implements IEnquiryService 
{
	@Autowired
	private IEnquiryDAO ienquiryDAO;
	
	@Override
	public Response businessEnquiry(BusinessEnquiry businessEnquiry)
	{
		return ienquiryDAO.businessEnquiry(businessEnquiry);
	}

	@Override
	public List<BusinessType> businessEnquiryInitialData() {
		// TODO Auto-generated method stub
		return ienquiryDAO.businessEnquiryInitialData();
	}

}
