package com.webstore.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.webstore.Entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, String> {
	UserEntity findByEmail(String email);
}
