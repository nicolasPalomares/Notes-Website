package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.domain.Note;

public interface NoteDao extends JpaRepository<Note, Long> {
}
