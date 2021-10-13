package com.customer.application.service;

import java.util.List;

import com.customer.application.models.Contact;

public interface ContactService {
	
	Contact saveContact(Contact contact);
	
	List<Contact> getAllContacts();
	
	Contact findById(Long id);
	
	Contact updateById(Long id, Contact contact);
	
	void deteleContactById(Long id);
	
	void saveFileAsJson(Contact contact) throws Exception;
	
	
	List<Contact> getListOfContactFromFile() throws Exception;

}
