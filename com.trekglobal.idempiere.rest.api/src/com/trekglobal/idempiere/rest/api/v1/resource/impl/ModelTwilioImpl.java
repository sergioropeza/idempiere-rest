package com.trekglobal.idempiere.rest.api.v1.resource.impl;

import javax.ws.rs.core.Response;

import org.compiere.util.DB;

import com.trekglobal.idempiere.rest.api.v1.resource.ModelTwilio;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Message;

public class ModelTwilioImpl implements ModelTwilio{




	public Response create(Object text) {
		
		
	
		return null;
	}

	@Override
	public Response handleIncomingMessage(String from, String body, String to) {
		 try {
	            String responseMessage = processMessage(from, body);
	            
	            // Crear respuesta TwiML
	            Message message = new Message.Builder(responseMessage).build();
	            MessagingResponse twiml = new MessagingResponse.Builder().message(message).build();
	            
	            return Response.ok(twiml.toXml()).build();
	            
	        } catch (Exception e) {
	            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
	        }
	}
	   private String processMessage(String from, String body) {
		   String text = "Gracias por tu mensaje. Hemos recibido: " + body;;
			String sqlUpdate = "Update C_BPartner set Address = "+DB.TO_STRING(text+"")+ " where C_BPartner_ID = 117";
			DB.executeUpdateEx(sqlUpdate, null);
	        
	        return text;
	    }

}
