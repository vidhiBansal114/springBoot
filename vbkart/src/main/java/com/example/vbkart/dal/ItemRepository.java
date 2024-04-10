package com.example.vbkart.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.vbkart.entity.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {
	@Query(name="Item.getItemByDesc",nativeQuery=true)
	List<Item> getItemByDesc(@Param("desc") String desc);

}
