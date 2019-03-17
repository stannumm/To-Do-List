package com.kalay.myapp2.account;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Account,Long> {
	public Account findByUsername(String username);
}
