package com.example.vbkart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vbkart.dal.ItemDetailsRepository;
import com.example.vbkart.entity.ItemDetails;

@Service
public class ItemDetailService {
	@Autowired
	ItemDetailsRepository itemDetailsRepository;
	public void delete(int id) {
		itemDetailsRepository.deleteById(id);
		
	}
	public List<ItemDetails> getItemDetailsForPrice(double id) {
		// TODO Auto-generated method stub
		return itemDetailsRepository.findByPriceGreaterThan(id);
	}
	public List<ItemDetails> getItemDetailsForCategory(String category) {
		return itemDetailsRepository.findByCategoryOrderByPrice(category);
		
	}

}
