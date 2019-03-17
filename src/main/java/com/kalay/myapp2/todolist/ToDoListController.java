package com.kalay.myapp2.todolist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kalay.myapp2.account.Account;
import com.kalay.myapp2.account.Response;


@RestController
public class ToDoListController {

    @Autowired
    private ToDoListService listService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/users/{userid}/lists")
    public List<ToDoList> getAllLists(@PathVariable long userid){
        return listService.getAllLists(userid);
       }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("users/{userid}/list")
    public Response addList(@RequestBody ToDoList todoList,@PathVariable long userid){
    	String listName = todoList.getName();
    	todoList.setUser(new Account(userid,"",""));
    	listService.addList(todoList);
    	return new Response("saved",null);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("users/{userid}/list/{listid}")
    public Response deleteList(@PathVariable long listid) {
    		listService.deleteList(listid);
    		return new Response("deleted",null);
    }
    //DELETE!!
    @RequestMapping("listtest")
    public List<ToDoList> getlisttest() {
    	return listService.getAlllllllLists();
    }

    
}