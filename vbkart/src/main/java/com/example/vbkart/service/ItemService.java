package com.example.vbkart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vbkart.dal.ItemDAL;
import com.example.vbkart.dal.ItemRepository;
import com.example.vbkart.entity.Item;

import jakarta.transaction.Transactional;

@Service
public class ItemService {
//	@Autowired
//	ItemDAL itemDAL;
	@Autowired
	ItemRepository itemRepository;
	//@Transactional
	public Item getItemById(int id) {
		return itemRepository.findById(id).get();
		// TODO Auto-generated method stub
		
	}
	//@Transactional
	public void saveItem(Item item) {
		// TODO Auto-generated method stub
		itemRepository.save(item);
		
	}
	//@Transactional
	public void deleteById(int id) {
		itemRepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}
	//@Transactional
	public void updateItem(Item item) {
		itemRepository.save(item);
		// TODO Auto-generated method stub
		
	}
	public List<Item> getItem() {
		// TODO Auto-generated method stub
		 List<Item> itemList=new ArrayList<>();
		 itemRepository.findAll().forEach(item->itemList.add(item));
		return itemList;
	}
	public List<Item> getItemByDesc(String desc) {
		// TODO Auto-generated method stub
		return itemRepository.getItemByDesc(desc);
	}

}
