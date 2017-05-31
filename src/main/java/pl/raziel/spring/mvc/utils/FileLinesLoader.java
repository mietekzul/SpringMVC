package pl.raziel.spring.mvc.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class FileLinesLoader {
	List<String> loadLines(String filePath) {
		try {
			return Files.readAllLines(Paths.get(new ClassPathResource(filePath).getURI()));
		} catch (IOException e) {
			throw new RuntimeException(
					String.format("Error while reading lines from file %s", filePath));
		}
	}
}
