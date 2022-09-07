package com.zdotavv.enterprise_homework2;

import com.zdotavv.enterprise_homework2.service.LanguageHandler;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class ResourceReader{
    @Autowired
    private LanguageHandler languageHandler;
    private ClassPathResource resource;
    private List<List<String>> records;
    public ResourceReader(String filePath) {
        resource = new ClassPathResource(filePath);
    }

    @PostConstruct
    public void reader() {
        String line;
        records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                resource.getInputStream()))) {
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(languageHandler.getLocale().getLanguage())) {
                    List<String> questions = new ArrayList<>();
                    String[] units = line.split(",");
                    Arrays.stream(units).forEach(s -> questions.add(s.trim()));
                    records.add(questions);
                }
            }
        }  catch (IOException e) {
        throw new RuntimeException(e);
    }
    }

}
