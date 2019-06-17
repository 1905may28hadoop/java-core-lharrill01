package com.revature.eval.java.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class EvaluationService {

	/**
	 * 1. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String[] splitphrase = phrase.split(" |-");
		String acryn = "";
		for(int i = 0; i < splitphrase.length;i++) {
			
				acryn += splitphrase[i].charAt(0);
				
			}
		 
		return acryn.toUpperCase();
	}
	
	/**
	 * 2. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		// TODO Write an implementation for this method declaration
		//Create a key for the program to follow

	   
//		Implement Hash Map
		
		string = string.toUpperCase();
		String[] testStringA = string.toUpperCase().split("");

	   Map<String, Integer> letval = new HashMap<String, Integer>();
	   int sum = 0;
	   
	   
	   letval.put("A", 1);
	   letval.put("E", 1);
	   letval.put("I", 1);
	   letval.put("O", 1);
	   letval.put("U", 1);
	   letval.put("L", 1);
	   letval.put("N", 1);
	   letval.put("R", 1);
	   letval.put("S", 1);
	   letval.put("T", 1);
	   letval.put("D", 2);
	   letval.put("G", 2);
	   letval.put("B", 3);
	   letval.put("C", 3);
	   letval.put("M", 3);
	   letval.put("P", 3);
	   letval.put("F", 4);
	   letval.put("H", 4);
	   letval.put("V", 4);
	   letval.put("W", 4);
	   letval.put("Y", 4);
	   letval.put("K", 5);
	   letval.put("X", 8);
	   letval.put("Q", 10);
	   letval.put("Z", 10);
	   
	   for(int i = 0; i < testStringA.length; i++) {
		 for(Map.Entry<String, Integer> entry: letval.entrySet()) {
			 if(entry.getKey().equals(testStringA[i])) {
				 sum += entry.getValue();
				 
			 }
		 }
	   }
	   	   
		return sum;
	}

	/**
	 * 3. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		// TODO Write an implementation for this method declaration
		//	Steps to clean up phone numbers
		//  		1. Remove "(",")", "-", "."
		int slen = string.length();
		
		string = string.replaceAll("\\s", "");		
		string = string.replaceAll("\\(","");
		string = string.replaceAll("\\)","");
		string = string.replaceAll("\\-", "");
		string = string.replaceAll("\\.", "");
		string = string.replaceAll("\\^+1", "");
		string = string.trim();
		//System.out.println(string);		
		int sslen = string.length();
		
		if(sslen > 11) {
			throw new IllegalArgumentException();
				}

		if(string.replaceAll("[0-9]", "").length() >= 1) {
			throw new IllegalArgumentException();
		}

		//string = string.replaceAll("\\s", "");
		
	
		//System.out.println(slen);
		//System.out.println(string);
		
		//  		2. Remove "1 ", remove 1 and trailing space 
		
		
		
	
		return string;
	}

	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {

		/*
		 * 		1. convert string to array
		 * 		2. use for loop to increment through array
		 * 		3. us if statement to compare index
		 * */
		string.replaceAll(",", "\\");
		String[] words = string.split("\\s");
		int arrlen = words.length;
		int[] sum = {0};
		for(int x = 0; x < arrlen; x++) {
			sum[x] = 0;
		
		//System.out.println(words[0]);
		for(int i = 0; i < arrlen; i++) {
			if(words[i] ==words[i+1]) {
				sum[x] += 1;
					
				}
				//System.out.println(sum);
			}
		}
		
		return null;
	}

	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;

		public int indexOf(T t) {
			// TODO Write an implementation for this method declaration
			
			
			return 0;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 6. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9. 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153, 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		// TODO Write an implementation for this method declaration
		
//		Computer Armstrong Number
//		1. Take input value and split digits into array
	/*
		
		int power = Integer.toString(input).length();
		int sum = 0;
		//System.out.println(input);
		int armnumber[] = new int[power];
		int i = 0;
		do {
			armnumber[i] = input % 10;
			input/= 10;
			if(input % 10 == 0) {
				//armnumber[i]=0;
//					System.out.println(a);
	//			}
				
				//System.out.println(input);
			}
			i++;
		}
		while(input != 0);
//		2. call each value and raise to the power of the number length
		
		for( int j = 0; j < power; j++) {

			sum += Math.pow(armnumber[j], power);
						
		}
		System.out.println(sum);
		if(sum == input) {
			return true;
		}
		else {
		
		return false;
		}
		*/
		//Using substrings
		int sum = 0;
		String incast = Integer.toString(input);
		for( int i = 0; i < incast.length(); i++) {
			sum += Math.pow(Integer.parseInt((incast.substring(i, i+1))), (double) incast.length()); 
		}
		return sum == input;
		
	}
	

	/**
	 * 7. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		List<Long> numl = new ArrayList<>();
		for(int i = 2; i < l; i++) {
			if(l%i == 0 && ifprime(i)) {
				numl.add((long) i);
			long l2 = l / i;
			while(l2 % i == 0 && l2 > 0) {
				l2 /=i;
				numl.add((long) i);
			}
		}
	}
		if(l == 2) {
			numl.add(2L);
		}
		//System.out.println(numl.toString());

		return numl;
	}
	public boolean ifprime(long a) {
		for(int i = 2; i < a; i++) {
			if(a%i == 0) {
				return false;
			}
		} return true;
	}


	/**
	 * 8-9. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 8
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			// TODO Write an implementation for this method declaration
			
			int ilen = string.length();
			String[] instr = string.toLowerCase().split("");
			String[] oustr = new String[ilen];
			   Map<String, String> cipherT = new HashMap<String, String>();
			   int sum = 0;
			   
			   cipherT.put("a", "z");
			   cipherT.put("b", "y");
			   cipherT.put("c", "x");
			   cipherT.put("d", "w");
			   cipherT.put("e", "v");
			   cipherT.put("f", "u");
			   cipherT.put("g", "t");
			   cipherT.put("h", "s");
			   cipherT.put("i", "r");
			   cipherT.put("j", "q");
			   cipherT.put("k", "p");
			   cipherT.put("l", "o");
			   cipherT.put("m", "n");
			   cipherT.put("n", "m");
			   cipherT.put("o", "l");
			   cipherT.put("p", "k");
			   cipherT.put("q", "j");
			   cipherT.put("r", "i");
			   cipherT.put("s", "h");
			   cipherT.put("t", "g");
			   cipherT.put("u", "f");
			   cipherT.put("v", "e");
			   cipherT.put("w", "d");
			   cipherT.put("x", "c");
			   cipherT.put("y", "b");
			   cipherT.put("z", "a");
			   cipherT.put("1", "1");
			   cipherT.put("2", "2");
			   cipherT.put("3", "3");
			   cipherT.put("4", "4");
			   cipherT.put("5", "5");
			   cipherT.put("6", "6");
			   cipherT.put("7", "7");
			   cipherT.put("8", "8");
			   cipherT.put("9", "9");
			   cipherT.put("0", "0");

			   for( int i = 0; i < ilen; i++) {
				   for(Map.Entry<String, String> entry: cipherT.entrySet()) { 
			   		   if(entry.getKey().equals(instr[i])) {  
			   			   oustr[i] = entry.getValue();
			   
			//System.out.println(instr[0]);
			   }
			   		  // if()
			   		  // if(oustr[i].equals(null)) {
			   			//   oustr[i].replaceAll(null, " ");
			   		   //}
			   		   
		   }
				    
				   }
		//System.out.println(Arrays.deepToString(oustr));	
		
		String enw = "";
        StringBuilder stringB = new StringBuilder();

        for (int j = 0; j < oustr.length; j++) {

              string = string+ oustr[j];
        } 
        //enw.replaceAll("null", "\\s");
            System.out.println(stringB);
        
        return stringB.toString();
			//return Arrays.toString(oustr);
	}

		/**
		 * Question 9
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			// TODO Write an implementation for this method declaration
			return null;
		}
	}

	/**
	 * 10. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		// TODO Write an implementation for this method declaration
		string = string.replace("What", "");
		string = string.replace("is", "");
		string = string.replace("by", "");
		string = string.replace("?", "");
				string = string.replaceAll("\\s", "");

		string = string.replace("plus", " + ");
		string = string.replace("minus", " - " );
		string = string.replace("multiplied", " * ");
		string = string.replace("divided", " / ");
		
		String[] wordp = string.split(" ");
		//System.out.println(Arrays.toString(wordp));
		switch(wordp[1]) {
		case "+": 
			return Integer.parseInt(wordp[0]) + Integer.parseInt(wordp[2]);
		case "-": 
			return Integer.parseInt(wordp[0]) - Integer.parseInt(wordp[2]);
		case "*": 
			return Integer.parseInt(wordp[0]) * Integer.parseInt(wordp[2]);
		case "/": 
			return Integer.parseInt(wordp[0]) / Integer.parseInt(wordp[2]);
		
		default:
			throw new IllegalArgumentException();
		}
		
		
		
		//System.out.println(string);
			
	}
}
