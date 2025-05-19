package com.trekglobal.idempiere.rest.api.v1.resource.impl;

import javax.ws.rs.core.Response;

import org.compiere.util.DB;

import com.trekglobal.idempiere.rest.api.v1.resource.ModelTwilio;

public class ModelTwilioImpl implements ModelTwilio{



	@Override
	public Response create(String text) {
		
		
		String sqlUpdate = "Update C_BPartner set Address = "+DB.TO_STRING(text)+ " where C_BPartner_ID = 117";
		DB.executeUpdateEx(sqlUpdate, null);
		return null;
	}

}
