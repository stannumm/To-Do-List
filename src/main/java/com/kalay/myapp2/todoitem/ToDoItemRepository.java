package com.kalay.myapp2.todoitem;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ToDoItemRepository extends CrudRepository<ToDoItem, Long> {
	public List<ToDoItem> findByListIdAndListUserId(long listId, long userId);
	public ToDoItem findByName(String name);

}
