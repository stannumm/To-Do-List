package com.kalay.myapp2.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoListService {

    @Autowired
    private ToDoListRepository todoRepo;

    public List<ToDoList> getAllLists(long id){

        List<ToDoList> lists = new ArrayList<>();
        todoRepo.findByUserId(id).forEach(lists::add);
        return lists;
    }
    
    public void addList(ToDoList list){
    	todoRepo.save(list);
    }
    public boolean contains(String username) {
    	if(todoRepo.findByName(username) == null) {
    		return false;
    	}
    	else return true;
    }

    public void deleteList(long id){
    	todoRepo.deleteById(id);
    }
    //BUNUSİL
    public List<ToDoList> getAlllllllLists(){

        List<ToDoList> lists = new ArrayList<>();
        todoRepo.findAll().forEach(lists::add);
        return lists;
    }

    /*
    public ToDoItem getAccountByName(String username) {
    	return todoRepo.findByName(username);
    }*/


    /*public ToDoItem getItem(long id) {
    	ToDoItem item = todoRepo.findById(id).get();
        return item;
    }*/



}
