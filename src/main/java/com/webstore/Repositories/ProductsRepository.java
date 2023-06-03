package com.webstore.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webstore.Entities.ProductEntity;
import com.webstore.Entities.UserEntity;

@Repository
public interface ProductsRepository extends CrudRepository<ProductEntity, Integer> {
	
	List<ProductEntity> findAll();
	
	List<ProductEntity> findByCategoryId(int category);
	
	List<ProductEntity> findByFavorite(int favorite);
	
	@Query("select p from ProductEntity p order by p.order desc limit 3")
	List<ProductEntity> findTop3ByOrder();
	
	@Query("select p from ProductEntity p where p.onsale <> 0")
	List<ProductEntity> findOnSaleProducts();

	void deleteById(int id);
}
