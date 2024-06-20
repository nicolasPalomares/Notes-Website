package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.dao.NoteDao;
import com.example.domain.Note;

@Service
public class NoteService implements iService<Note> {

	@Autowired
	private NoteDao noteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Note> listEntity() {
		return (List<Note>) noteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Note findEntity(Note note) {
		return noteDao.findById(note.getId()).orElse(null);
	}

	@Override
	@Transactional
	public void saveEntity(Note note) {
		noteDao.save(note);
	}

	@Override
	@Transactional
	public void deleteEntity(Note note) {
		noteDao.delete(note);
	}

}
