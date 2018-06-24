package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface ToDoListEntryRepository extends CrudRepository<ToDoListEntry, Long> {

}
