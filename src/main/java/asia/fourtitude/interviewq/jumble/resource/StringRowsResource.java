package asia.fourtitude.interviewq.jumble.resource;

import java.util.List;

/**
 * Represents resource that holds information in more than a single line
 */
public enum StringRowsResource {
	GAME_WORDS("words.txt"),
	;
	
	private final String path;

	private StringRowsResource(String path) {
		this.path = path;
	}

	/**
	 * Retrieves the resource located by the assigned {@code path}
	 * 
	 * @return
	 */
	public List<String> getResource() {
		String classPath = new StringBuilder("classpath:").append(path).toString();
		return ResourceReader.getStringRows(ResourceRetriever.retrieve(classPath));
	}
}
