package com.kalay.myapp2.todoitem;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.kalay.myapp2.todolist.ToDoList;


@Entity
public class ToDoItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	private String name;
	private String deadline;
	private String createDate;
    private boolean isCompleted;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    ToDoList list;
    
    public ToDoItem(){}
    
	public ToDoItem(long id, String name, String deadline, String createDate, boolean isCompleted, ToDoList list) {
		super();
		this.id = id;
		this.name = name;
		this.deadline = deadline;
		this.createDate = createDate;
		this.isCompleted = isCompleted;
		this.list = list;
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
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public ToDoList getToDoList() {
		return list;
	}
	public void setToDoList(ToDoList toDoList) {
		this.list = toDoList;
	}
    
    
	
}
