package com.zdotavv.enterprise_homework2.service;

import com.zdotavv.enterprise_homework2.ResourceReader;
import com.zdotavv.enterprise_homework2.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class QuizService  {
    @Autowired
    private LanguageHandler languageHandler;
    @Autowired
    private ResourceReader resourceReader;
    @Autowired
    private User user;
    private int number;
    private int score;

    public void answer() {
        Scanner scanner = new Scanner(System.in);
        for (number = 0; number < resourceReader.getRecords().size(); number++){
            System.out.println(languageHandler.getBundle().getString("questionNumber")+Question());
            if (checkAnswer(scanner.nextLine())) {
                score++;
            }
        }
        System.out.println("\n" + user.getName() + " " + user.getSurname() + "\n"
                + languageHandler.getBundle().getString("rightAnswers") + score + " " + languageHandler.getBundle().getString("outOfPossible") + resourceReader.getRecords().size());
    }

    public String Question() {
        List<String> record = resourceReader.getRecords().get(number);
        return record.get(1) +"\n" + String.join(
                ", ", record.get(2)+ "\n"+ record.get(3)+"\n"+ record.get(4)+"\n"+ record.get(5)+"."+"\n"+ languageHandler.getBundle().getString("numberOfAnswer")) ;
    }

    public boolean checkAnswer(String answer) {
        return resourceReader.getRecords().get(number).get(6).equals(answer);
    }

}




