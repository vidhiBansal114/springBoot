package com.example.vbkart.dal;

import com.example.vbkart.entity.Item;

public interface ItemDAL {
	Item getById(int id);

	void save(Item item);

	void delete(int id);

	void updateItem(Item item);

}
