package com.kalay.myapp2.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id;
	    private String username;
	    private String password;

	    public Account(){}

	    public Account(long id,String username, String password) {
	        this.username = username;
	        this.password = password;
	        this.id = id;
	    }

	    public long getId() {
			return id;
		}

		public String getUsername() {
	        return username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }
}
