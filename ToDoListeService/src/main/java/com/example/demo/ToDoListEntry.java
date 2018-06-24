package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ToDoListEntry {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private boolean completed;
	private String category;
	
	ToDoListEntry() {}
	
	/*ToDoListEntry(String title, String category) {
		this.title = title;
		this.completed = false;
		this.category = category;
	}*/
	
	ToDoListEntry(String title) {
		this.title = title;
		this.completed = false;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}	
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String toString() {
		return id + " Title: " + title + " Completed: " + completed;
	}

}
