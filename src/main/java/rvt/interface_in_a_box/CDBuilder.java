package rvt.interface_in_a_box;

public class CDBuilder {
    private String author;
    private String title;
    private int year;

    public CDBuilder author(String author) {
        this.author = author;
        return this;
    }

    public CDBuilder title(String title) {
        this.title = title;
        return this;
    }

    public CDBuilder year(int year) {
        this.year = year;
        return this;
    }

    public CD build(){
        return new CD(author, title, year);
    }
}
