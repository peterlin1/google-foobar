package level_three;
//package com.google.challenges;

import java.util.HashMap;
import java.util.Map;

//import org.apache.commons.lang3.time.StopWatch;

/**
 * 
 * @author Peter
 * With her LAMBCHOP doomsday device finished, Commander Lambda is preparing for her debut on the galactic stage - but in order to make a 
 * grand entrance, she needs a grand staircase! As her personal assistant, you've been tasked with figuring out how to build the best 
 * staircase EVER. 
 * 
 * Lambda has given you an overview of the types of bricks available, plus a budget. You can buy different amounts of the different types 
 * of bricks (for example, 3 little pink bricks, or 5 blue lace bricks). Commander Lambda wants to know how many different types of staircases
 * can be built with each amount of bricks, so she can pick the one with the most options. 
 * 
 * Each type of staircase should consist of 2 or more steps.  No two steps are allowed to be at the same height - each step must be lower
 * than the previous one. All steps must contain at least one brick. A step's height is classified as the total amount of bricks that make 
 * up that step.
 * 
 * For example, when N = 3, you have only 1 choice of how to build the staircase, with the first step having a height of 2 and the second 
 * step having a height of 1: (# indicates a brick)
 * 
 * #
 * ##
 * 21
 * 
 * When N = 4, you still only have 1 staircase choice:
 * #
 * #
 * ##
 * 31
 * 
 * But when N = 5, there are two ways you can build a staircase from the given bricks. The two staircases can have heights (4, 1) or (3, 2), 
 * as shown below:
 * #
 * #
 * #
 * ##
 * 41
 * 
 * #
 * ##
 * ##
 * 32
 * 
 * Write a function called answer(n) that takes a positive integer n and returns the number of different staircases that can be built from 
 * exactly n bricks. n will always be at least 3 (so you can have a staircase at all), but no more than 200, because Commander Lambda's not 
 * made of money!
 * 
 */

public class the_grandest_staircase_of_them_all {
	private static Map<Integer, Map<Integer, Integer>> mem_map;
	
    public static int answer(int n) {
      	mem_map = new HashMap<Integer, Map<Integer, Integer>>();
    	return next_val(n, 0);
    } 
	
    public static int next_val(int n, int height) {
    	if (n == 0) {
    		return 1;
    	}
    	else if ((n - height) <= 0) return 0;
    	else {
    		Map<Integer, Integer> node_map;
    		if (mem_map.containsKey(n)) {
    			node_map = mem_map.get(n);
    			if (node_map.containsKey(height)) return node_map.get(height);
    			int chain_val = 0;
        		if (height == 0) {
    	    		for (int next_height = height + 1; next_height < n; next_height++) {
    	    			chain_val = chain_val + next_val(n - next_height, next_height);
    	    			mem_map.get(n).put(height, chain_val);
    	    		}
        		} else {
    	    		for (int next_height = height + 1; next_height <= n; next_height++) {
    	    			chain_val = chain_val + next_val(n - next_height, next_height);
    	    			mem_map.get(n).put(height, chain_val);
    	    		}
        		}
        		return chain_val;
    		} else {
    			node_map = new HashMap<Integer, Integer>();
    			int chain_val = 0;
        		if (height == 0) {
    	    		for (int next_height = height + 1; next_height < n; next_height++) {
    	    			chain_val = chain_val + next_val(n - next_height, next_height);
    	    			node_map.put(height, chain_val);
    	    			mem_map.put(n, node_map);
    	    		}
        		} else {
    	    		for (int next_height = height + 1; next_height <= n; next_height++) {
    	    			chain_val = chain_val + next_val(n - next_height, next_height);
    	    			node_map.put(height, chain_val);
    	    			mem_map.put(n, node_map);
    	    		}
        		}
        		return chain_val;
    		}
    	}
    }
    
	public static void main(String[] args) {
//		StopWatch timer = new StopWatch();
//		timer.start();
		// 1
		System.out.println(answer(3));
		// 1
		System.out.println(answer(4));
		// 2
		System.out.println(answer(5));
		// 2
		System.out.println(answer(10));
		// 487067745
		// Answer with Memoization Execution time: 0.052163291 seconds.
		// Answer without Memoization Execution time: 17.103186586 seconds.
		System.out.println(answer(200));
		// timer.stop();
		// System.out.println("Execution time: " + timer.getNanoTime() / (Math.pow(10, 9)) + " seconds.");
	}
}
