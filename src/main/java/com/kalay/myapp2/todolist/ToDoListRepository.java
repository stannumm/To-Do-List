package com.kalay.myapp2.todolist;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ToDoListRepository extends CrudRepository<ToDoList, Long> {
	public List<ToDoList> findByUserId(long id);
	public ToDoList findByName(String name);

}
