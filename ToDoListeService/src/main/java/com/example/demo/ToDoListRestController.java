package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class ToDoListRestController {
	
	@Autowired
	private ToDoListEntryRepository repository;
	
	@GetMapping(path = "/api/todos", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<ToDoListEntry> todos(){
		return repository.findAll();
	}
	
	@GetMapping(path = "/todos/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<ToDoListEntry> singleTodo(@PathVariable Long id){
		return repository.findById(id);
	}
	
	/*@PostMapping("/todos/{title}/{category}")
	String create(@PathVariable String title, @PathVariable String category){
		repository.save(new ToDoListEntry(title,category));
		return title + category + " is saved.";
	}*/
	
	@PostMapping("/todos/{title}")
	String create(@PathVariable String title){
		repository.save(new ToDoListEntry(title));
		return title + " is saved.";
	}
	
	@PutMapping("/todos/{id}")
	void update(@PathVariable Long id){
		Optional<ToDoListEntry> optionalToDoListEntry = repository.findById(id);
		if(optionalToDoListEntry.isPresent()) {
			ToDoListEntry toDoListEntry = optionalToDoListEntry.get();
			toDoListEntry.setCompleted(true);
			repository.save(toDoListEntry);
		}
	}
	
	@DeleteMapping("/todos/{id}")
	void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
}
