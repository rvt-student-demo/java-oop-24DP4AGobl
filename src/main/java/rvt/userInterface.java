package rvt;

import java.util.Scanner;

public class userInterface {
    private toDoList toDoList;
    private Scanner scanner;

    public userInterface(toDoList toDoist, Scanner scanner){
        this.toDoList = toDoist;
        this.scanner = scanner;
    }
    public void start(){
        while(true){
            System.out.print("Command: ");
            String cmd = scanner.nextLine();

            if (cmd.equals("add")){
                System.out.print("To add: ");
                String word = scanner.nextLine();
                toDoList.add(word);
            } else if (cmd.equals("list")){
                toDoList.print();
            } else if (cmd.equals("remove")){
                System.out.print("Which one is removed? ");
                int number = Integer.valueOf(scanner.nextLine());
                toDoList.remove(number);
            } else if (cmd.equals("stop")) {
                break;
            } 
        }
    }
}
