package rvt;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;
import java.io.*;


public class toDoList{
    private ArrayList<String> list;
    private final String filePath = "data/todo.csv";

    public toDoList(){
        this.list = new ArrayList<>();
        loadFromFile();
    }
    public void add(String task){
        this.list.add(task);
        
        try (PrintWriter pWriter = new PrintWriter(new FileWriter(filePath, true))){
            pWriter.println(getLastId() + "," + task);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
    public void print(){
        for(int i = 0; i < list.size(); i++) {
            System.out.println(i+1 + ": " + list.get(i));
        }
    }

    private void loadFromFile() {
        try(Scanner reader = new Scanner(new File(filePath))){
            reader.nextLine();
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                String[] parts = row.split(",");
                String name = parts[1];

                list.add(name);
            }
        }catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private boolean updateFile() {
        try (PrintWriter pWriter = new PrintWriter(new FileWriter(filePath))){
            pWriter.println("id,task");
            for(int i = 0; i < list.size()-1; i++ ){
                pWriter.println(i + "," + list.get(list.size() - 1));
            }
            return true;
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            return false;
        }
    }

    public void remove(int id) {
        list.remove(id-1);
        updateFile();
    }

    public boolean checkEventString(String value) {
        if(Pattern.matches("^[a-zA-Z0-9 ]+$", value) && value.length() > 3) { //error
            return true;
        }
        return false;
    }

    private int getLastId() {
        return list.size();
    }
}