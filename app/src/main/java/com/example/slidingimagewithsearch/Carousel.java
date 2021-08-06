package com.example.slidingimagewithsearch;

import java.util.ArrayList;

public class Carousel {

    private String image;
    private ArrayList<Student> students;

    public Carousel(String image, ArrayList<Student> students) {
        this.image = image;
        this.students = students;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
