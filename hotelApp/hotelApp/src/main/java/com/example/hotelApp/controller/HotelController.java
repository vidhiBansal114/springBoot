package com.example.hotelApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotelApp.dto.HotelRequest;
import com.example.hotelApp.model.Hotel;
import com.example.hotelApp.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	HotelService hotelservice;
	
	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public void createHotel(@RequestBody HotelRequest hotelRequest) {
		hotelservice.createHotel(hotelRequest);
		
	}
	@GetMapping("/id/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Hotel getHotelById(@PathVariable Long id)
	{
		return hotelservice.getHotelById(id);
	}
	
	@GetMapping("/getAll")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Hotel> getAllHotels()
	{
		return hotelservice.getAllHotels();
	}
	
	@DeleteMapping("/remove/id/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteHotelById(@PathVariable Long id)
	{
		hotelservice.deleteHotelById(id);
		
	}

}
