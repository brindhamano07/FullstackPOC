package com.customer.application.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.application.exceptions.ResourceNotFoundException;
import com.customer.application.models.Contact;
import com.customer.application.repositories.ContactRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@JsonIgnoreProperties(ignoreUnknown=true)
public class ContactServiceImpl implements ContactService {

	
	@Autowired ContactRepository contactRepo;
	@Override
	public Contact saveContact(Contact contact) {
		
		return contactRepo.save(contact);
	}

	@Override
	public List<Contact> getAllContacts() {
		
		return contactRepo.findAll();
	}

	@Override
	public Contact findById(Long id) {
		
		return contactRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Contact not found"));
	}

	@Override
	public Contact updateById(Long id, Contact contact) {
		
		Contact dbContact = contactRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Contact not found"));
		
		BeanUtils.copyProperties(contact, dbContact);
		
		return contactRepo.save(dbContact);
	}

	@Override
	public void deteleContactById(Long id) {
		
		contactRepo.deleteById(id);
		
	}

	@Override
	public void saveFileAsJson(Contact contact) throws Exception {
		
		FileInputStream fis = new FileInputStream(new File("src/main/resources/contact.json"));
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode contactJson = mapper.readTree(fis);
		
		System.out.println("The contact json is "+ contactJson);
		
		List<Contact> contacts = mapper.readValue(contactJson.toString(), new TypeReference<List<Contact>>() {
		});
		
		System.out.println("The contact list is "+ contacts);
		
		fis.close();
		
		contacts.add(contact);
		
		System.out.println("The contact after adding in  list is "+ contacts);
		
		mapper.writeValue(new File("src/main/resources/contact.json"), contacts);
	}

	@Override
	public List<Contact> getListOfContactFromFile() throws Exception {
		
		
FileInputStream fis = new FileInputStream(new File("src/main/resources/contact.json"));
		
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode contactJson = mapper.readTree(fis);
		
		System.out.println("The contact json is "+ contactJson);
		
		List<Contact> contacts = mapper.readValue(contactJson.toString(), new TypeReference<List<Contact>>() {
		});
		
		System.out.println("The contact list is "+ contacts);
		
		fis.close();
		
		return contacts;
		
	}
	
	

}
