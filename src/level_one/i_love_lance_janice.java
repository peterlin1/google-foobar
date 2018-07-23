package level_one;
//package com.google.challenges; 

/**
 * 
 * @author Peter
 * You've caught two of your fellow minions passing coded notes back and forth - while they're on duty, no less! 
 * Worse, you're pretty sure it's not job-related - they're both huge fans of the space soap opera "Lance & Janice". 
 * You know how much Commander Lambda hates waste, so if you can prove that these minions are wasting her time passing non-job-related notes, it'll put you that much closer to a 
 * promotion.
 * 
 *  Fortunately for you, the minions aren't exactly advanced cryptographers. In their code, every lowercase letter [a..z] is replaced with \
 *  the corresponding one in [z..a], while every other character (including uppercase letters and punctuation) is left untouched.  
 *  That is, 'a' becomes 'z', 'b' becomes 'y', 'c' becomes 'x', etc.  For instance, the word "vmxibkgrlm", when decoded, would become 
 *  "encryption".
 *  
 *  Write a function called answer(s) which takes in a string and returns the deciphered string so you can show the commander proof that 
 *  these minions are talking about "Lance & Janice" instead of doing their jobs.
 *
 */

public class i_love_lance_janice {
	
	public static String answer(String s) {
		char[] conv = s.toCharArray();
		String ret = new String();
		int char_to_dec;
		for (int idx=0; idx < conv.length; idx++) {
			char_to_dec = (int) conv[idx];
			if (char_to_dec < 97) {
				ret += s.charAt(idx);
			} else if (char_to_dec <= 109) {
				ret += (char) (char_to_dec + 25 - 2 * (char_to_dec - 97));
			} else if (char_to_dec <= 122) {
				ret += (char) (char_to_dec - 25 + 2 * (122 - char_to_dec));
			} else { 
				ret += s.charAt(idx);
			}
		}
		return ret; 
	}
	
	public static void main(String [] args) {
		// "did you see last night's episode?"
		System.out.println(answer("wrw blf hvv ozhg mrtsg'h vkrhlwv?"));
		System.out.println(answer("Yvzs! I xzm'g yvorvev Lzmxv olhg srh qly zg gsv xlolmb!!"));
	}
}
