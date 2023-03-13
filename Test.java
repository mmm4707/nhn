package nhn;
import nhn.example.Lecture;
import nhn.example.LectureIterator;
import nhn.example.Student;

public class Test {
    public static void main(String[] args) {
        Lecture lecture = new Lecture(5);
        lecture.add(new Student(1,"Celine","computer","yeosu"));
        lecture.add(new Student(2,"Lee","computer","gwangju"));
        lecture.add(new Student(3,"Kim","iot","seoul"));
        lecture.add(new Student(4,"Jang","aslfd","dfdf"));
        lecture.add(new Student(5,"Anold","dfd","sdfa"));

        LectureIterator iterator = (LectureIterator) lecture.iterator();

        while (iterator.hasNext()){
            Object str = iterator.next();
            System.out.println(str);
        }
    }
}
