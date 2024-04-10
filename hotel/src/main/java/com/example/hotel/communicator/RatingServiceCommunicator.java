package com.example.hotel.communicator;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import com.example.hotel.exception.HttpRatingServiceNotFound;
@Service
public class RatingServiceCommunicator {
	private final RestTemplate restTemplate;
	
	@Autowired
	public RatingServiceCommunicator(RestTemplateBuilder restTemplateBuilder ) {
		this.restTemplate=restTemplateBuilder.build();
		
	}
	public long getRating(String id) {
		String url="http://localhost:8089/rating/id/";
		System.out.println(url);
		//ResponseEntity<Long> response=restTemplate.getForEntity(url+id, Long.class);
		Long ratingResponse=restTemplate.getForObject(url+id,Long.class);
		return ratingResponse;		
	}
	public void addRating(Map<String, Long> ratingsMap) {
		// TODO Auto-generated method stub
		String url="http://localhost:8089/rating/add/";

		//restTemplate.postForObject(url, ratingsMap, Object.class);
		HttpEntity<Map<String, Long>> requestEntity=new HttpEntity<Map<String, Long>>(ratingsMap);
		restTemplate.exchange(url, HttpMethod.POST,requestEntity,Object.class);
	}
	public void updateRating(Map<String, Long> ratingsMap) {

		String url="http://localhost:8089/rating/update";
		HttpEntity<Map<String, Long>> requestEntity=new HttpEntity<Map<String, Long>>(ratingsMap);
		System.out.print(ratingsMap);
		restTemplate.exchange(url, HttpMethod.PUT,requestEntity,Object.class);

		
	}
	public void deleteRating(String id) {
		String url="http://localhost:8089/rating/id/";
		try {
			restTemplate.exchange(url+id,HttpMethod.DELETE,null,Object.class);
				
		}
		catch(HttpClientErrorException e) {
			throw new HttpRatingServiceNotFound(HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value()));
			
		}
		
	}
}
