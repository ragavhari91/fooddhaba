package com.fooddhaba.foodmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fooddhaba.foodmarket.model.BusinessEnquiry;
import com.fooddhaba.foodmarket.model.BusinessType;
import com.fooddhaba.foodmarket.model.LoginResponse;
import com.fooddhaba.foodmarket.model.Response;
import com.fooddhaba.foodmarket.model.User;
import com.fooddhaba.foodmarket.service.IEnquiryService;

@RequestMapping("/enquiry")
@RestController
public class EnquiryController 
{
	@Autowired
	private IEnquiryService ienquiryService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/business/create")
	@ResponseBody
	public Response businessEnquiry(@RequestBody BusinessEnquiry businessEnquiry) 
	{
		return ienquiryService.businessEnquiry(businessEnquiry);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/business/initial")
	@ResponseBody
	public List<BusinessType> businessEnquiryInitialData() 
	{
		return ienquiryService.businessEnquiryInitialData();
	}
	
	
}
