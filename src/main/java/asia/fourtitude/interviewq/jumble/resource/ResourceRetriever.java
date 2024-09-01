package asia.fourtitude.interviewq.jumble.resource;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public abstract class ResourceRetriever {
	private static final ResourceLoader resourceLoader = new DefaultResourceLoader(
			ResourceRetriever.class.getClassLoader());

	protected static Resource retrieve(String path) {
		return resourceLoader.getResource(path);
	}
}
