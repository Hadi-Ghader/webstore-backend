package com.webstore.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webstore.Entities.UsersProductsMappingEntity;

@Repository
public interface UsersProductsMappingRepository extends CrudRepository<UsersProductsMappingEntity, Integer> {
}
