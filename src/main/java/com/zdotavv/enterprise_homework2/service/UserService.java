package com.zdotavv.enterprise_homework2.service;

import com.zdotavv.enterprise_homework2.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

@Getter
@Setter
public class UserService  {
    @Autowired
    private User user;
    @Autowired
    private LanguageHandler languageHandler;


    public void userNameAndSurname() {
        System.out.println("\n"+languageHandler.getBundle().getString("welcome"));
        Scanner scanner = new Scanner(System.in);
        boolean isFilled = false;
        while (!isFilled) {
            System.out.println(languageHandler.getBundle().getString("addName"));
            user.setName(scanner.nextLine());
            System.out.println(languageHandler.getBundle().getString("addSurname"));
            user.setSurname(scanner.nextLine());
            if (isInputNotEmpty()) {
                isFilled = true;
            } else {
                System.out.println("inputIsEmpty");
            }
        }
    }

    public boolean isInputNotEmpty() {
        return !user.getName().isEmpty() && !user.getSurname().isEmpty();
    }

}
