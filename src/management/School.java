package management;

import models.Principal;
import models.Teacher;
import models.Principal;

public class School {
    private String schoolName;
    private Classroom[] classrooms;
    private Teacher[] teachers;
    private Principal principal;

    public School(String schoolName){
        this.schoolName = schoolName;
        this.classrooms = new Classroom[5];
        this.teachers = new Teacher[6];
    }

    public void setupClassrooms(Classroom[] classrooms){
        this.classrooms = classrooms;
    }

    public void setTeachers(Teacher[] teachers){
        this.teachers = teachers;
    }

    public void setPrincipal(Principal principal){
        this.principal = principal;
    }

    public boolean isSchoolFull(){
        int counter = 0;
        for(int i=0;i<classrooms.length;i++){
            if(classrooms[i].isClassroomFull()){
                counter++;
            }
        }

        if(counter==classrooms.length){
            return true;
        }
        else{
            return false;
        }
    }

    public void displayAllSchoolInfo(){
        System.out.println("\n=== SCHOOL: " + schoolName.toUpperCase() + " ===");

        if(principal != null){
            System.out.println("Principal: " + principal.getName() + ", Experience: " + principal.getExperience());
        }

        System.out.println("---------------------------------");

        for(int i=0; i<classrooms.length; i++){
            if(classrooms[i] != null){
                classrooms[i].displayClassroom();
            }
        }
        System.out.println("=================================");
    }
}
