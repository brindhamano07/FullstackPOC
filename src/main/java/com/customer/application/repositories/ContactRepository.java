package com.customer.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.application.models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
