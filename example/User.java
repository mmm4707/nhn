package nhn.example;

class User implements Comparable <User> {
    private final int userNo;
    private final String userName;
    private final int userAge;

    public int getUserAge() {
        return userAge;
    }

    public User(int userNo, String userName, int userAge) {
        this.userNo = userNo;
        this.userName = userName;
        this.userAge = userAge;
    }
    @Override
    public int compareTo(User o){
        if(this.userAge == o.userAge){
            return 0;
        }
        else if(this.userAge < o.userAge){
            return 1;
        }
        else{
            return -1;
        }
    }

    @Override
    public String toString(){
        return "User {" +
                "userNo" + this.userNo +
                ", userName" + this.userName +
                ", user Age" + this.userAge + ")";
    }
}