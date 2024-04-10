package com.example.hotel.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.hotel.communicator.RatingServiceCommunicator;
import com.example.hotel.exception.HotelNotFoundException;
import com.example.hotel.model.Hotel;

@Service
public class HotelService {
	
	List<Hotel> hotelList=new ArrayList<>();
	HashMap<String,Hotel> hotelMap=new HashMap<>();
	@Autowired
	RatingServiceCommunicator ratingServiceCommunicator;
	
	public void createHotel(Hotel hotel) {
		hotelList.add(hotel);
		hotelMap.put(hotel.getId(), hotel);
		Map<String, Long> ratingsMap=new HashMap<>();	
		ratingsMap.put(hotel.getId(),hotel.getRating());
		ratingServiceCommunicator.addRating(ratingsMap);
		
	}
	public Hotel getHotelById(String id) {
		if(ObjectUtils.isEmpty(hotelMap.get(id))) {
			throw new HotelNotFoundException("Hotel not found");
		}
		Hotel hotel=hotelMap.get(id);
		long updatedRating=ratingServiceCommunicator.getRating(id);
		hotel.setRating(updatedRating);
		return hotelMap.get(id);
	}
	public List<Hotel> getAllHotels(){
		return hotelList;
	}
	public void deleteHotelById(String id) {
		Hotel hotel=getHotelById(id);
		hotelList.remove(hotel);
		hotelMap.remove(id);
		ratingServiceCommunicator.deleteRating(id);
	}
	public void updateHotel(Hotel hotel) {
		Hotel existingHotel=getHotelById(hotel.getId());
		hotelList.remove(existingHotel);
		hotelList.add(hotel);
		hotelMap.put(hotel.getId(), hotel);
		Map<String, Long> updatedRatings=new HashMap<>();
		updatedRatings.put(hotel.getId(),hotel.getRating());
		ratingServiceCommunicator.updateRating(updatedRatings);

	}
}
