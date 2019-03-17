package com.kalay.myapp2.todoitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoItemService {

    @Autowired
    private ToDoItemRepository todoRepo;

    public List<ToDoItem> getAllItems(long listId, long userId){

        List<ToDoItem> items = new ArrayList<>();
        todoRepo.findByListIdAndListUserId(listId, userId).forEach(items::add);
        return items;
    }
    
    public void addItem(ToDoItem item){
    	todoRepo.save(item);
    }
    
    public void updateItem(ToDoItem doItem) {
    	todoRepo.save(doItem);
    }
 
    public void deleteItem(long id){
    	todoRepo.deleteById(id);
    }
    
    //BUNUSİL
    public List<ToDoItem> getLiterallyAllItems(){

        List<ToDoItem> items = new ArrayList<>();
        todoRepo.findAll().forEach(items::add);
        return items;
    }
}
