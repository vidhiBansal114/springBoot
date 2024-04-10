package com.example.vbkart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vbkart.entity.Item;
import com.example.vbkart.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemService itemservice;
	
	@GetMapping("/id/{id}")
	public Item getItemById(@PathVariable int id) {
		return itemservice.getItemById(id);
	}
	@GetMapping("/all")
	public List<Item> getItem(){
		return itemservice.getItem();
	}
	@PostMapping("/save")
	public void saveItem(@RequestBody Item item) {
		System.out.print(item.getName());
		itemservice.saveItem(item);
		
	}
	@DeleteMapping("/delete/id/{id}")
	public void deleteItem(@PathVariable int id) {
		itemservice.deleteById(id);
		
	}
	@PutMapping("/update")
	public void updateUpdateItem(@RequestBody Item item) {
		itemservice.updateItem(item);
		
	}
	@GetMapping("/desc/{desc}")
	public List<Item> getItemByDesc(@PathVariable String desc){
		return itemservice.getItemByDesc(desc);
		
	}

}
