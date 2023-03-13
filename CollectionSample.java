package nhn;
import java.util.*;

public class CollectionSample {
    List<String> list = new LinkedList<>();

    public void add(String value){
        this.list.add(value);
    }

    public void remove(String value){
        this.list.remove(value);
    }

    public static void main(String [] args) {
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World!");


        for (String value : list) {
            System.out.println(value);
        }
    }
}
