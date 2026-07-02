package management;

import models.Teacher;
import models.Student;

public class Classroom {
    private String name;
    private Teacher teacher;
    private Student[] students;
    private int studentCount = 0;

    public Classroom(String name) {
        this.name = name;
        this.students = new Student[20]; //Maximum capacity of class is 20.
        this.studentCount = 0;
    }

    public String getName() {
        return name;
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public boolean addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount] = student;
            studentCount++;
            return true;
        }
        System.out.println("Classroom " + name + " is full!");
        return false;
    }

    public void displayClassroom() {
        System.out.println("\n--- Classroom: " + name + " ---");
        if(teacher != null) {
            System.out.println("Teacher Name: " + teacher.getName());
        }
        else{
            System.out.println("No teacher found!");
        }

        System.out.println("Total Students: " + studentCount + "/20");

        System.out.println("Students:");
        for(int i = 0; i < studentCount; i++){
            System.out.println("- ID: "  + students[i].getId() + ", Name: " + students[i].getName());
        }
    }

    public boolean isClassroomFull() {
        if(studentCount == students.length){
            return true;
        }
        else {
            return false;
        }
    }

}
