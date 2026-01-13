package rvt;

import java.util.ArrayList;

public class toDoList{
    private ArrayList<String> list;

    public toDoList(){
        this.list = new ArrayList<>();
    }
    public void add(String task){
        list.add(task);
    }
    public void print(){
        for(int i = 0; i < list.size(); i++) {
            System.out.println(i+1 + ": " + list.get(i));
        }
    }
    public void remove(int number){
        list.remove(number-1);
    }
}