package asia.fourtitude.interviewq.jumble.core;

import java.util.Collection;
import java.util.List;

public class PalindromeChecker {
	public List<String> filterPalindromes(Collection<String> words) {
		return words.parallelStream().filter(this::isPalindrome).toList();
	}
	
	/**
	 * Checks if the {@code word} passed is a palindrome
	 * 
	 * @param word
	 * @return
	 */
	public boolean isPalindrome(String word) {
		int length = word.length();
		
		// It doesn't count if the length is 1
		if (length <= 1) {
			return false;
		}
		
		int halfLength = length / 2;
		boolean isEven = isEven(word);
		
		
		int limit = isEven 
				// If the word count is even, do nothing
				? halfLength
				// If the word count is even, we don't need to
				// check the middle character
				: halfLength - 1;

		// Second pointer to compare directly with the first index
		int secondPointerIndex = length - 1;
		for (int i = 0; i < limit; i++) {
			if (word.charAt(i) != word.charAt(secondPointerIndex - i)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean isEven(String word) {
		int integralDivision = word.length() / 2;
		float precisionDivision = word.length() / 2;
		return precisionDivision == (float) integralDivision;
	}
}
