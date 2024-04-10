package com.example.vbkart.dal;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.vbkart.entity.ItemDetails;

public interface ItemDetailsRepository extends CrudRepository<ItemDetails, Integer> {

	List<ItemDetails> findByPriceGreaterThan(double price);
	//@Query("Select itd from ItemDetails itd where itd.category=?1 ORDER BY itd.price DESC")
	List<ItemDetails> findByCategoryOrderByPrice(String category);
}
