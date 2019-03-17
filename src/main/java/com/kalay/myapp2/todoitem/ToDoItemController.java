package com.kalay.myapp2.todoitem;

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
import com.kalay.myapp2.todolist.ToDoList;


@RestController
public class ToDoItemController {

    @Autowired
    private ToDoItemService itemService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/users/{userid}/list/{listid}/items")
    public List<ToDoItem> getAllItems(@PathVariable long listid, @PathVariable long userid){
        return itemService.getAllItems(listid,userid);
       }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("users/{userid}/list/{listid}/item")
    public Response addItem(@RequestBody ToDoItem todoItem,@PathVariable long userid,@PathVariable long listid){
    	String itemName = todoItem.getName();
    		todoItem.setToDoList(new ToDoList(listid,"",new Account(userid,"","")));
    		itemService.addItem(todoItem);
    		return new Response("saved",null);
    	
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("users/{userid}/list/{listid}/item/{itemid}")
    public Response deleteItem(@PathVariable long itemid) {
    		itemService.deleteItem(itemid);
    		return new Response("deleted",null);
    }
    
    //DELETE!!
    @RequestMapping("/test")
    public List<ToDoItem> getitemstest(){
    	return itemService.getLiterallyAllItems();
    }
}