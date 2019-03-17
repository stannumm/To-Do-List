package com.kalay.myapp2.todolist;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.kalay.myapp2.account.Account;

@Entity
public class ToDoList {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	private String name;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Account user;
    
    public ToDoList() {}
    
	public ToDoList(long id, String name, Account user) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account getUser() {
		return user;
	}
	public void setUser(Account user) {
		this.user = user;
	}
    
   
    
}
