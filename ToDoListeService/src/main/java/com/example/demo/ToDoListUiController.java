package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@SpringBootApplication
public class ToDoListUiController {

	@Autowired
	private ToDoListEntryRepository repository;
	

	@RequestMapping(method = RequestMethod.GET)
    String list(Model model){
        Iterable<ToDoListEntry> todos = repository.findAll();
        model.addAttribute("todos", todos);
        return "todos";
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public String addTodo(String title) {
		repository.save(new ToDoListEntry(title));
		return "redirect:/ui/";
	}
	
	@RequestMapping(value="/done/{id}", method = RequestMethod.POST)
	public String doneTodo(@PathVariable Long id) {
		Optional<ToDoListEntry> optionalToDoListEntry = repository.findById(id);
		if(optionalToDoListEntry.isPresent()) {
			ToDoListEntry toDoListEntry = optionalToDoListEntry.get();
			toDoListEntry.setCompleted(true);
			repository.save(toDoListEntry);
		}	
		return "redirect:/ui/";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
	public String deleteTodo(@PathVariable Long id) {
		repository.deleteById(id);
		return "redirect:/ui/";
	}
	
	@RequestMapping(value="/category/{id}", method = RequestMethod.POST)
	public String categoryTodo(@PathVariable Long id, String category) {
		Optional<ToDoListEntry> optionalToDoListEntry = repository.findById(id);
		if(optionalToDoListEntry.isPresent()) {
			ToDoListEntry toDoListEntry = optionalToDoListEntry.get();
			toDoListEntry.setCategory(category);
			repository.save(toDoListEntry);
		}	
		return "redirect:/ui/";
	}
	
}
