package asia.fourtitude.interviewq.jumble.resource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

public class ResourceReader {
	public static String getString(Resource resource) {
		try (Reader reader = new InputStreamReader(resource.getInputStream())) {
			return FileCopyUtils.copyToString(reader);
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	public static List<String> getStringRows(Resource resource) {
		String rawResource = getString(resource);
		return Arrays.asList(StringUtils.split(rawResource, ResourceConstants.NEW_LINE));
	}
}
