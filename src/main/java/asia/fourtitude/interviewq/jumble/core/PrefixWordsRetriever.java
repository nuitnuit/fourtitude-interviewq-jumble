package asia.fourtitude.interviewq.jumble.core;

import java.util.Collection;
import java.util.Collections;

import org.apache.commons.collections4.Trie;
import org.apache.commons.collections4.trie.PatriciaTrie;
import org.apache.commons.lang3.StringUtils;

public class PrefixWordsRetriever {
	private final Trie<String, String> prefixIndexor = new PatriciaTrie<String>();
	private final StringComparatorMode mode;

	public PrefixWordsRetriever(StringComparatorMode mode, Collection<String> words) {
		this.mode = mode;
		words.stream().map(mode::apply).forEach(word -> prefixIndexor.put(word, word));
	}
	
	/**
	 * Retrieves words with the given prefix
	 * 
	 * @param prefix
	 * @return
	 */
	public Collection<String> of(String prefix) {
		if (prefix == null || StringUtils.isEmpty(prefix)) {
			return Collections.emptyList();
		}
		return prefixIndexor.prefixMap(mode.apply(prefix)).values();
	}
}
