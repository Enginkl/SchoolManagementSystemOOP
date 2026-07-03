package app;

import com.sun.tools.jconsole.JConsoleContext;
import models.Branch;
import models.Principal;
import models.Student;
import models.Teacher;
import management.Classroom;
import management.School;

import java.util.Scanner;

public class AppMenu {
    private Scanner scanner;
    private School school;
    private Classroom[] classrooms;

    public AppMenu(){
        scanner = new Scanner(System.in);
        classrooms = new Classroom[5];
    }

    public void start(){
        System.out.println("Welcome to Student Management System");
        initializeCompulsoryData();
        runMenu();
    }

    public void initializeCompulsoryData(){
        System.out.print("Enter the name of the school: ");
        this.school = new School(scanner.nextLine());

        String[] classNames = {"A","B","C","D","E"};
        for(int i=0; i<5;i++){
            classrooms[i] = new Classroom(classNames[i]);
        }
        school.setupClassrooms(classrooms);

        Teacher t1 = new Teacher("Ahmet", Branch.MATHS);
        Teacher t2 = new Teacher("Ayşe", Branch.PHYSICS);
        Teacher t3 = new Teacher("Mehmet", Branch.GEOGRAPHY);
        Teacher t4 = new Teacher("Fatma", Branch.BIOLOGY);
        Teacher t5 = new Teacher("Ali", Branch.CHEMISTRY);
        Teacher t6 = new Teacher("Murat", Branch.LITERATURE);

        Teacher[] teachers = {t1,t2,t3,t4,t5,t6};

        System.out.println("");
        for(int i=0; i<6; i++){
            System.out.print(i+1 + ": ");
            teachers[i].displayTeacherInfo();
        }
        System.out.print("Choose one teacher as a principal: ");
        int choice = scanner.nextInt();

        int selectedIndex = choice - 1;

        Teacher chosenTeacher = teachers[selectedIndex];

        Principal principal = new Principal(chosenTeacher.getName(), chosenTeacher.getBranch(),10);

        school.setPrincipal(principal);

        int cIndex = 0;
        for(int i=0;i<6;i++) {
            if(i != selectedIndex && cIndex < 5) {
                classrooms[cIndex].assignTeacher(teachers[i]); // Öğretmeni sınıfa ata
                cIndex++; // Bir sonraki sınıfa geç
            }
        }

        school.setTeachers(teachers);

        System.out.println("\nCompulsory initialization completed successfully!\n");
    }

    public void runMenu(){
        boolean isRunning = true;

        String Menu = "--- MAIN MENU ---\n"
                + "1. Add Student\n"
                + "2. Display All School Info\n"
                + "3. Exit Program\n";

        while(isRunning){
            System.out.println(Menu);
            System.out.println("----------------------");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1){

                if(school.isSchoolFull()){
                    System.out.println("Error: The school is completely full! No more students can be added.");
                    continue;
                }

                System.out.print("Enter Student ID: ");
                String id =  scanner.nextLine();
                System.out.print("Enter Student Name: ");
                String name =  scanner.nextLine();

                System.out.println("Classrooms with avaible space:");
                for(int i=0;i<5;i++){
                    if(classrooms[i].isClassroomFull() == false){
                        System.out.print(i + ": ");
                        System.out.println(classrooms[i].getName());
                    }
                }
                System.out.print("Select classroom index to add student: ");
                int classIndex = scanner.nextInt();
                scanner.nextLine();

                if(classIndex >= 0 && classIndex <   5){
                    Student student = new Student(id,name);
                    boolean success = classrooms[classIndex].addStudent(student);
                    if(success){
                        System.out.println("Student added successfully to Classroom " + classrooms[classIndex].getName());
                    }
                }
                else {
                    System.out.println("Invalid classroom index!");
                }

            }
            else if(choice == 2){
                school.displayAllSchoolInfo();
            }
            else if(choice == 3){
                isRunning = false;
                System.out.println("Exiting System...");
            }
            else{
                System.out.println("Invalid choice. Try again!");
            }
        }
    }
}
