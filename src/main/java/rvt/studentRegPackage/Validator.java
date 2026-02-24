package rvt.studentRegPackage;

import java.util.Scanner;

public class Validator {
    StudentManager manager;

    public Validator(StudentManager manager){
        this.manager = manager;
    }
    public String getValidInput(Scanner scanner, String prompt, String regex) {
        String input;
        while(true){

            System.out.print(prompt);
            input = scanner.nextLine();

            if (manager.checkExistenceOf(input)) {
                System.out.printf("%s jau eksiste, ievadi datus atkartoti%n", input);
                continue; 
            }

            if(input.matches(regex)) {
                return input;
            }
            
            System.out.println("Invalid format. Please Try again.");
        }
    }
    
    public static String checkName() {
        final String nameRegEX = "^[a-zA-Z]{3,20}$";

        return nameRegEX;
    }

    public static String checkSurname() {
        final String surnameRegEX = "^[a-zA-Z]{3,20}$";
    
        return surnameRegEX;
    }

    public static String checkEmail() {
        final String emailRegEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    
        return emailRegEX;
    }

    public static String checkCode() {
        final String codeRegEX = "^[0-9]{3,11}$";
        return codeRegEX;
    }
}
