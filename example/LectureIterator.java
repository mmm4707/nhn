package nhn.example;
import nhn.example.Lecture;

import java.util.Iterator;

public class LectureIterator implements Iterator{
    Lecture lecture;
    int index = 0;

    public LectureIterator(Lecture lecture){
        this.lecture = lecture;
    }
    @Override
    public boolean hasNext() {
        if(this.index < lecture.students.length){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Object next(){
        return this.lecture.students[this.index++];
    }

}
