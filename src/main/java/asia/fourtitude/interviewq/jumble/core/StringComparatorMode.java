package asia.fourtitude.interviewq.jumble.core;

import java.util.function.Function;

public enum StringComparatorMode {
	CASE_INSENSITIVE(String::toLowerCase), 
	CASE_SENSITIVE(word -> word),
	;

	private final Function<String, String> searchWordTransformer;

	private StringComparatorMode(Function<String, String> searchWordTransformer) {
		this.searchWordTransformer = searchWordTransformer;
	}

	String apply(String transformSearchWord) {
		return searchWordTransformer.apply(transformSearchWord);
	}
}