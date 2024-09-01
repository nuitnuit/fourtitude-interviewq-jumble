package asia.fourtitude.interviewq.jumble.core;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class WordSearcher {
	private static final String anyWord = "\\w";
	private static final String lengthParameter = "{%d}";
	private static final String characterParameter = "%s";
	private static final String startToken = "^";
	private static final String endToken = "$";
	
	private static final Predicate<String> checkIfEnglishAlphabet = Pattern.compile("[a-zA-Z]").asMatchPredicate(); 

	private final List<String> words;
	private final StringComparatorMode mode;
	

	public WordSearcher(StringComparatorMode mode, List<String> words) {
		this.mode = mode;
		this.words = words.stream().map(mode::apply).toList();
	}

	/**
	 * Returns words that starts and ends with specific characters, and with a given
	 * length. Returns an empty list if all parameters are null.
	 * 
	 * @param startCharacter
	 * @param endCharacter
	 * @param length
	 * @return
	 */
	public List<String> search(Character startCharacter, Character endCharacter, Integer length) {
		InputValidity validity = verifyInputValidity(startCharacter, endCharacter, length);
		if (!validity.proceedWithProcessing()) {
			return Collections.emptyList();
		}
		
		StringBuilder stringBuilder = new StringBuilder();

		if (validity.startCharacterValidity()) {
			stringBuilder.append(startToken).append(String.format(characterParameter, mode.apply(startCharacter.toString())));
		}

		if (validity.lengthValidity()) {
			stringBuilder.append(anyWord).append(String.format(lengthParameter, length));
		}

		if (validity.endCharacterValidity()) {
			stringBuilder.append(String.format(characterParameter, mode.apply(endCharacter.toString()))).append(endToken);
		}

		Pattern pattern = Pattern.compile(stringBuilder.toString());
		return words.stream().filter(pattern.asMatchPredicate()).toList();
	}
	
	private InputValidity verifyInputValidity(Character startCharacter, Character endCharacter, Integer length) {
		if (startCharacter == null && (length == null || length < 1) && endCharacter == null) {
			return InputValidity.failed();
		}
		boolean startCharacterCheck = startCharacter == null ? true
				: Character.isSpaceChar(startCharacter) && checkIfEnglishAlphabet.test(startCharacter.toString());

		boolean endCharacterCheck = endCharacter == null ? true
				: Character.isSpaceChar(endCharacter) && checkIfEnglishAlphabet.test(endCharacter.toString());
		
		return new InputValidity(startCharacterCheck, endCharacterCheck, true);
	}
	
	private static record InputValidity(boolean startCharacterValidity, boolean endCharacterValidity, boolean lengthValidity) {
		public boolean proceedWithProcessing() {
			return startCharacterValidity || endCharacterValidity || lengthValidity;
		}

		/**
		 * A static constructor for failed input validity
		 * 
		 * @return
		 */
		public static InputValidity failed() {
			return new InputValidity(false, false, false);
		}
	}
}
