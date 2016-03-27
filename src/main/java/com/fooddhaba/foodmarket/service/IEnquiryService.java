package com.fooddhaba.foodmarket.service;

import java.util.List;

import com.fooddhaba.foodmarket.model.BusinessEnquiry;
import com.fooddhaba.foodmarket.model.BusinessType;
import com.fooddhaba.foodmarket.model.Response;

public interface IEnquiryService {

	Response businessEnquiry(BusinessEnquiry businessEnquiry);

	List<BusinessType> businessEnquiryInitialData();

}
