package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackerController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/tracker")
	public String updateTracker(@RequestParam(value = "url", defaultValue = "http://google.com") String url) {
		int count = Tracker.getCountMap().get(url)==null?0:Tracker.getCountMap().get(url);
		count++;
		Tracker.getCountMap().put(url, count);
		return "Referred from the site : " + url+ "  " + count + " times";
	}
}
