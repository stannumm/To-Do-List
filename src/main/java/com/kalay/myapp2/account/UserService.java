package com.kalay.myapp2.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Account> getAllUsers(){

        List<Account> accounts = new ArrayList<>();
        userRepository.findAll().forEach(accounts::add);
        return accounts;
    }

    public Account getUser(long id) {
        Account account = userRepository.findById(id).get();
        return account;
    }

    public void addUser(Account account){
        userRepository.save(account);
    }

    public boolean contains(String username) {
    	if(userRepository.findByUsername(username) == null) {
    		return false;
    	}
    	else return true;
    }
    
    public Account getAccountByUsername(String username) {
    	return userRepository.findByUsername(username);
    }

    public void deleteAccount(long id){
    	userRepository.deleteById(id);
    }




}
