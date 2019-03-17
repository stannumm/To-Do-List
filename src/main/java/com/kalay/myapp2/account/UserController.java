package com.kalay.myapp2.account;

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


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //@CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/users")
    public List<Account> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping("/users/{username}")
    public Account getUser(@PathVariable String username){
        return userService.getAccountByUsername(username);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signup")
    public Response addUser(@RequestBody Account account){
    	String username = account.getUsername();
        if(userService.contains(username))
        	return new Response("inuse",null);
        else
        {
            userService.addUser(account);
            return new Response("saved",null);
        }
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/users")
    public Account login(@RequestBody Account account){
    	String username = account.getUsername();
		String password = account.getPassword();
		Account realAccount;
		if(userService.contains(username)) {
			realAccount = userService.getAccountByUsername(username);
			if(realAccount.getPassword().equals(password)) {
				return realAccount;
			}
			else return null;
		}
		else return null;
		
    }
    
    @DeleteMapping("/users/{userid}")
    public Response deleteAccount(@PathVariable long userid) {
    	userService.deleteAccount(userid);
		return new Response("deleted",null);
    }
}