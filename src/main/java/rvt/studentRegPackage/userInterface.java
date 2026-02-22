package rvt.studentRegPackage;

import java.util.Scanner;
import java.time.LocalDateTime;

public class UserInterface {
    StudentManager manager;
    Scanner scanner;
    Validator validator;

    public UserInterface(StudentManager manager, Scanner scanner, Validator validator) {
        this.manager = manager;
        this.scanner = scanner;
        this.validator = validator;
    }

    public void start() {
        while(true){
            System.out.print("Command: ");
            String command = scanner.nextLine().toLowerCase();
            if (command.equals("help")) {
                manager.help();
            } else if (command.equals("register")) {
                String code = validator.getValidInput(scanner, "Personcode: ", Validator.checkCode());
                String name = validator.getValidInput(scanner, "Name: ", Validator.checkName());
                String surname = validator.getValidInput(scanner, "Surname", Validator.checkSurname());
                String email = validator.getValidInput(scanner, "Email", Validator.checkEmail());

                manager.register(new StudentBuilder()
                                    .code(code)
                                    .name(name)
                                    .surname(surname)
                                    .email(email)
                                    .regTime(LocalDateTime.now())
                                    .build());
            } else if (command.equals("show")) {
                manager.show();
            } else if (command.equals("remove")) {
                System.out.print("Ievadiet personas personas kodu kuru velaties izdzest: ");
                String code = scanner.nextLine().toLowerCase();
                System.out.print("Ko velaties nomainit: ");
                String field = scanner.nextLine().toLowerCase();
                System.out.printf("Ievadiet jauno %s", code);
                String newValue = scanner.nextLine().toLowerCase();
                System.out.println();

                manager.edit(code, field, newValue);
            } else if (command.equals("exit")) {
                break;
            }
        }
    }
}