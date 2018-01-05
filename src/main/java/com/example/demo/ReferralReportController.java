package com.example.demo;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;


@RestController
public class ReferralReportController {

	@RequestMapping("/referralReport")
	public ResponseEntity getReport() {	
		
		
		
		ResponseEntity.status(HttpStatus.ACCEPTED);
		//Tracker.getTrackerResult(); 
		Gson gson = new Gson();
		String json = gson.toJson(Tracker.getTrackerResult());
		
		return new ResponseEntity<String>(json, null, HttpStatus.CREATED);
	}
}
