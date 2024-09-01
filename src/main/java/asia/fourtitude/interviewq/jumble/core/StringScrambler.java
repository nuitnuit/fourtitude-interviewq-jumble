package asia.fourtitude.interviewq.jumble.core;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class StringScrambler {	
	/**
	 * Scrambles the given {@code word} such that it will never 
	 * @param word
	 * @return
	 */
	public String scramble(String word) {
		// Parsing
		List<Character> container = word.chars().mapToObj(integer -> (char) integer).collect(Collectors.toList());

		// Shuffling
		Collections.shuffle(container);

		String scrambled = String.valueOf(container.toArray());

		// If the scrambled word is the same, re-scramble it
		if (StringUtils.equals(word, scrambled)) {
			return scramble(word);
		}

		return scrambled;
	}
}