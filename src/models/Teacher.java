package models;

public class Teacher {
    private String name;
    private Branch branch;

    public Teacher(String name, Branch branch) {
        this.name = name;
        this.branch = branch;
    }

    public void displayTeacherInfo(){
        System.out.println(this.name + ", " + this.branch);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
