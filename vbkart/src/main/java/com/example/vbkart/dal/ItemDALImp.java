package com.example.vbkart.dal;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.vbkart.entity.Item;


import jakarta.persistence.EntityManager;
@Repository
public class ItemDALImp implements ItemDAL {
	@Autowired
	EntityManager entitymanager;
	
	@Override
	public Item getById(int id) {
		// TODO Auto-generated method stub
		Session session=entitymanager.unwrap(Session.class);
		Item item=session.get(Item.class,id);
		return item;
	}

	@Override
	public void save(Item item) {
		// TODO Auto-generated method stub
		Session session=entitymanager.unwrap(Session.class);
			session.save(item);
		//session.update(session);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session=entitymanager.unwrap(Session.class);
		Item item=session.get(Item.class,id);
		session.delete(item);

	}

	@Override
	public void updateItem(Item item) {
		// TODO Auto-generated method stub
		Session session=entitymanager.unwrap(Session.class);
		Item currentItem=session.get(Item.class,item.getId());
		currentItem.setDescription(item.getDescription());
		currentItem.setDescription(item.getName());
		session.save(currentItem);
	}

}
