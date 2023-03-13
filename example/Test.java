package nhn.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        User user1 = new User(1, " Celine", 30);
        User user2 = new User(2,"Alabama",20);
        User user3 = new User(3,"Paloma", 10);
        User user4 = new User(4,"Kim", 50);
        User user5 = new User(5,"Jang", 90);

        List<User> list = new ArrayList<User>() {
            {
                add(user1);
                add(user2);
                add(user3);
                add(user4);
                add(user5);
            }
        };

        for(User u: list){
            System.out.println(u);
        }
        System.out.println("------sort ---------");

        Collections.sort(list, (o1, o2) -> o2.getUserAge() - o1.getUserAge());

        for(User u: list){
            System.out.println(u);
        }
    }
}
