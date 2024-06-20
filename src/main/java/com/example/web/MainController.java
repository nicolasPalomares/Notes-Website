package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.domain.Contact;
import com.example.domain.Note;
import com.example.service.iService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	private iService<Note> noteService;
	
	@Autowired
	private iService<Contact> contactService;
	
	@GetMapping("/")
	public String indexRedirect(Model model, @AuthenticationPrincipal User user) {
		var contacts = contactService.listEntity();
		var notes = noteService.listEntity();
		model.addAttribute("contacts", contacts);
		model.addAttribute("notes", notes);
		model.addAttribute("totalContacts", contacts.size());
		model.addAttribute("totalNotes", notes.size());
		return "index";
	}
	
	@GetMapping("/editContact")
	public String editContact(Contact contact, Model model) {
		contact = contactService.findEntity(contact);
		model.addAttribute("contact", contact);
		return "updateContact";
	}
	
	@GetMapping("/editNote")
	public String editNote(Note note, Model model) {
		note = noteService.findEntity(note);
		model.addAttribute("note", note);
		return "updateNote";
	}
	
	@PostMapping("/saveContact")
	public String saveContact(@Valid Contact contact, Errors errors, Model model) {
		if(errors.hasErrors()) {
			return "updateContact";
		}
		contactService.saveEntity(contact);
		return "redirect:/";
	}
	
	@PostMapping("/saveNote")
	public String saveNote(@Valid Note note, Errors errors, Model model) {
		if(errors.hasErrors()) {
			return "updateNote";
		}
		noteService.saveEntity(note);
		return "redirect:/";
	}
	
	@GetMapping("/deleteContact")
	public String deleteContact(Contact contact, Model model) {
		contactService.deleteEntity(contact);
		return "redirect:/";
	}
	
	@GetMapping("/deleteNote")
	public String deleteNote(Note note, Model model) {
		noteService.deleteEntity(note);
		return "redirect:/";
	}

}
