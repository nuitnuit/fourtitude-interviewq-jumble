package asia.fourtitude.interviewq.jumble.core;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class WordExistentialityChecker {
	private final Set<String> words;
	private final StringComparatorMode mode;

	public WordExistentialityChecker(StringComparatorMode mode, Collection<String> words) {
		this.mode = mode;
		this.words = words.stream().map(mode::apply).collect(Collectors.toUnmodifiableSet());
	}

	/**
	 * Checks if the given word exists
	 * 
	 * @param word
	 * @return
	 */
	public boolean exists(String word) {
		if (word == null) {
			return false;
		}
		return words.contains(mode.apply(word));
	}
}
