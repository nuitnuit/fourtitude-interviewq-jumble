package asia.fourtitude.interviewq.jumble.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

public class RandomWordPicker {
	private final List<String> words;
	private final Map<Integer, List<String>> wordsByLength;

	public RandomWordPicker(Collection<String> words) {
		this.words = new ArrayList<>(words);
		this.wordsByLength = new WordProcessor().groupWordsByLength(this.words);
	}

	/**
	 * Retrieves a random word with the specified length. Read more on the returned
	 * word.
	 * 
	 * @param length
	 * @return An {@link Optional} with a random word of specified length, an empty
	 *         {@link Optional} if no words is found with the specified length, or a
	 *         random word if the length is null
	 * @see #get() for getting a random word
	 */
	public Optional<String> getFromLength(Integer length) {
		if (length == null) {
			return get();
		}

		if (length <= 0) {
			throw new IllegalArgumentException(String.format("Received invalid %d length requirement", length));
		}
		List<String> dataset = wordsByLength.getOrDefault(length, null);

		if (dataset == null) {
			return Optional.empty();
		}

		// Return a random number from the dataset if there are any
		Random random = new Random();
		return Optional.of(dataset.get(random.nextInt(dataset.size() - 1)));
	}

	/**
	 * Returns a random word
	 * 
	 * @return
	 */
	public Optional<String> get() {
		Random random = new Random();
		return Optional.of(words.get(random.nextInt(words.size() - 1)));
	}
}
