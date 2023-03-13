package nhn;

public class Student {
    private int studentNo;
    private String name;
    private String department;
    private String address;

    public Student (int studentNo, String name, String department, String address){
        this.studentNo = studentNo;
        this.name = name;
        this.department = department;
        this.address = address;
    }

    public void setStudentNo(int studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public int getStudentNo() {
        return studentNo;
    }

    public void setDepartment(String department){
        this.department = department;
    }

}
