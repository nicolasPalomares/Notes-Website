package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.dao.ContactDao;
import com.example.domain.Contact;

@Service
public class ContactService implements iService<Contact> {
	
	@Autowired
	private ContactDao contactDao;

	@Override
	@Transactional(readOnly = true)
	public List<Contact> listEntity() {
		return (List<Contact>) contactDao.findAllByOrderByNameAsc();
	}

	@Override
	@Transactional(readOnly = true)
	public Contact findEntity(Contact contact) {
		return contactDao.findById(contact.getId()).orElse(null);
	}

	@Override
	@Transactional
	public void saveEntity(Contact contact) {
		contactDao.save(contact);
	}

	@Override
	@Transactional
	public void deleteEntity(Contact contact) {
		contactDao.delete(contact);
	}

}
