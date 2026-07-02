# School Management System

A Java-based Command Line Interface (CLI) application designed to simulate a basic school management environment. This project focuses on demonstrating core Object-Oriented Programming (OOP) principles through a clean and structured architecture.

## 🚀 Features

* **Dynamic Role Assignment:** Elect a principal from the existing teaching staff and automatically distribute the remaining teachers to available classrooms.
* **Classroom Management:** Track student capacity (maximum 20 students per classroom) and prevent over-enrollment.
* **Student Registration:** Add new students to specific classrooms via a user-friendly console menu.
* **Comprehensive Display:** View detailed information about the school, including the principal, all teachers, classrooms, and enrolled students.
* **Input Validation:** Secure data entry using Enum structures to prevent typos in specific fields (e.g., teaching branches).

## 🧠 OOP Concepts Applied

This project is built with a strong emphasis on clean code and structural integrity. The following Java/OOP concepts are actively utilized:

* **Inheritance:** The `Principal` class extends the `Teacher` class, inheriting its base properties while adding specific attributes like experience.
* **Encapsulation:** All model properties are set to `private` and accessed strictly through `getter` and `setter` methods to ensure data security.
* **Composition:** The `School` object is composed of `Classroom` and `Teacher` arrays, demonstrating a "has-a" relationship.
* **Enums:** Teacher subjects (e.g., MATHS, PHYSICS) are strictly defined using a `Branch` enum for type safety.
* **Separation of Concerns (Packages):** * `models/`: Contains the core entities (`Student`, `Teacher`, `Principal`, `Branch`).
    * `management/`: Handles the business logic and array manipulation (`School`, `Classroom`).
    * `app/`: Manages the user interface, Scanner inputs, and application lifecycle (`Main`, `AppMenu`).

## 🛠️ Tech Stack

* **Language:** Java (JDK 8+)
* **Paradigm:** Object-Oriented Programming (OOP)
* **Environment:** Command Line Interface (CLI)

## 🎮 How to Run

1. Clone the repository to your local machine:
   ```bash
   git clone [https://github.com/yourusername/SchoolManagementSystem.git](https://github.com/yourusername/SchoolManagementSystem.git)
