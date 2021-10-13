package com.customer.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.customer.application.models.Contact;
import com.customer.application.models.ContactDTO;
import com.customer.application.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired ContactService contactService;
    @PostMapping("/save")
    public Contact saveContact(@RequestBody Contact contact) throws Exception{
    	System.out.println("Contact DTO "+contact);
    	if(contact.getSource().equals(ContactDTO.Source.db)) {
    		return contactService.saveContact(contact);
    	}
    	else {
    		contactService.saveFileAsJson(contact);
    		return contact;
    	}	
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getUsers(@RequestParam String source) throws Exception{
    	if(source.equals(ContactDTO.Source.db.name())) {
        return ResponseEntity.ok(
          contactService.getAllContacts()
        );
    	}
    	else {
    		return ResponseEntity.ok(contactService.getListOfContactFromFile());
    	}
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getUser(@PathVariable(value = "id" ) Long id){
      
        return  ResponseEntity.ok().body(contactService.findById(id));
    }

    @PutMapping("/{id}")
    public Contact updateUser(@RequestBody Contact newContact, @PathVariable(value = "id") Long id){
        
    	return contactService.updateById(id, newContact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable(value = "id") Long id){
        
    	contactService.deteleContactById(id);
    	
        return ResponseEntity.ok().build();
    }




}
