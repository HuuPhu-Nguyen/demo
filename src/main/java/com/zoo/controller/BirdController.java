package com.zoo.controller;

import java.util.ArrayList;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.entity.Bird;
import com.zoo.repository.BirdRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class BirdController {

	@Autowired
	BirdRepository birdRepository;
	
	@PostMapping("/birds")
	public String saveBird(@RequestBody Bird birds) {
		birdRepository.save(birds);
		return "Birds saved successfully";
	}
	
	@GetMapping("/bird")
	public ResponseEntity<ArrayList<Bird>> getAllBirds(){
		ArrayList<Bird> listOfBirds = new ArrayList<Bird>();
		birdRepository.findAll().forEach(listOfBirds::add);
		return new ResponseEntity<ArrayList<Bird>>(listOfBirds,HttpStatus.ACCEPTED);
	}
}
