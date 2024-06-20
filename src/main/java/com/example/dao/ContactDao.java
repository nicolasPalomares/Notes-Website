package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.domain.Contact;

public interface ContactDao extends JpaRepository<Contact, Long> {
	List<Contact> findAllByOrderByNameAsc();
}
