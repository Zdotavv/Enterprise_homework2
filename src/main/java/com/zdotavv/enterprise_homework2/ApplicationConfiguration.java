package com.zdotavv.enterprise_homework2;

import com.zdotavv.enterprise_homework2.service.*;
import org.springframework.context.annotation.Bean;

public class ApplicationConfiguration {
    private static final String FILE_PATH = "questions.csv";

    @Bean(name = "UserService")
    public UserService userService () {
        return new UserService();
    }

    @Bean(name = "languageHandler")
    public LanguageHandler languageHandler() {
        return new LanguageHandler();
    }

    @Bean(name = "user")
    public User user() {
        return new User();
    }

    @Bean(name = "QuizService")
    public QuizService quizService() {
        return new QuizService();
    }

    @Bean(name = "resourceReader")
    public ResourceReader resourceReader() {
        return new ResourceReader(FILE_PATH);
    }
}
