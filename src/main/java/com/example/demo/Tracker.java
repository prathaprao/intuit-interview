package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.*;

public class Tracker {
	private int count;
	private static HashMap<String, Integer> countMap = new HashMap<String, Integer>();
	private static TrackerResult[] topUrls = new TrackerResult[3];

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public static HashMap<String, Integer> getCountMap() {
		return countMap;
	}

	public static void setCountMap(HashMap<String, Integer> countMap) {
		Tracker.countMap = countMap;
	}
	



/*	public static String[] getTopUrls() {
		return topUrls;
	}

	public static void setTopUrls(String[] topUrls) {
		Tracker.topUrls = topUrls;
	}*/

	/**
	 * 1) This sorts the HashMap with nlogn time complexity.
	 * For better performance, following options.
	 * a) Sort the results in a seperate thread. 
	 * b) Cache the results.
	 * c) There can be little time buffer delay of 30 seconds/1hr. 
	 * @return String
	 */
	public static TrackerResult[] getTrackerResult() {
		Set<Entry<String, Integer>> set = countMap.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){ //nlogn time complexity.
		public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 ) {
			return (o2.getValue()).compareTo( o1.getValue() );
		}
				});
		
		for(Entry<String, Integer> entry:list) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		TrackerResult tr;
		for(int i=0;i<3 && i< list.size();i++){
			Entry<String, Integer> entry = list.get(i);
			tr = new TrackerResult();
			tr.setDomain(entry.getKey());
			tr.setCount(entry.getValue());
			topUrls[i] = tr;			 
		}
		return topUrls;
	}
}
