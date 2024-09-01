package asia.fourtitude.interviewq.jumble.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordProcessor {
	public Map<Integer, List<String>> groupWordsByLength(List<String> words) {
		return words.stream()
				.collect(Collectors.groupingBy(String::length, HashMap::new, Collectors.toCollection(ArrayList::new)));
	}
}
