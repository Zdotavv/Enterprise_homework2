package com.zdotavv.enterprise_homework2;

import com.zdotavv.enterprise_homework2.service.QuizService;
import com.zdotavv.enterprise_homework2.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        UserService userService = context.getBean(UserService.class);
        QuizService quizService = context.getBean(QuizService.class);

        userService.userNameAndSurname();
        quizService.answer();
    }
}
