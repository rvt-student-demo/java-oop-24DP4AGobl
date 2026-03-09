package rvt.interface_in_a_box;

import java.util.ArrayList;

public class Box implements Packable{
    private ArrayList<Packable> box;

    public Box(){
        box = new ArrayList<Packable>();
    }

    public double weight() {
        double weight = 0;
        for (Packable obj : box) {
            weight += obj.weight();
        }
        return weight;
    }

    public void add(Packable object) {
        box.add(object);
    }

    private int totalItems(){
        return box.size();
    }

    @Override

    public String toString() {
        return "Box: " + totalItems() + " items" + ", " + "total weight " + weight() + " kg";
    }
}
