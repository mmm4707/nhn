package nhn.example;

import java.util.*;

public class Lecture implements  Iterable{
    Student[] students;
    int index = 0;
    public Lecture(int size){
        this.students = new Student[size];
    }

    public void add(Student student){
        if(this.index >= students.length){
            System.out.println("Class is full");
        }
        else{
            this.students[this.index++] = student;
        }
    }
    @Override
    public Iterator iterator() {
        return new LectureIterator(this);
    }

}
