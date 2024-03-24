# LEARNING PROGRESS TRACKER

This program is about tracking the learning process and obtaining information about specific courses and students. The program has several features, explained below.

**Command "add students":** This command firstly validates students' credentials (first name, second name, email address). If the validation is correct, it adds students to a map of students with unique IDs automatically generated. At the end, it prints the amount of added students.

**Command "list":** This command simply shows a list of students with their ID specifiers.

**Command "add points":** You can add points using a unique ID to specific courses. In this program, we have four courses (Java, DSA, Databases, Spring). In this format, the ID starts at 10000, followed by points for each course (e.g., 20 25 0 60). The first number is the ID, starting from 10000.

**Command "find":** You can find a student by their ID and view the points they have gained in every course.

**Command "statistics":** First, it shows you categories of courses:
- **Popularity:** Depends on the number of enrolled students.
- **Activity:** Depends on the number of contributions (points added).
- **Complexity:** Depends on the total points gained.
When you see this table, you can obtain detailed information about every course in the table. You can see enrolled students in a specific course, their points, and their learning progress in %. This table is sorted by points in descending order.
**Command "notify":** Notifies every student who has successfully completed a course. It sends a notification message with the name of the student and the completed course. At the end, it prints the number of notified students.

**How to Run the Project**

1. **Clone the Project**: Use Git to clone the project repository (`git clone https://github.com/OwnStyle777/contactsManager.git`) .

2. **Download ZIP File**: Alternatively, you can download the project as a ZIP file and extract it to a designated folder on your local machine.

3. **Open Project in IDE**: After cloning or extracting, open the project folder in your preferred Integrated Development Environment (IDE), such as IntelliJ IDEA.

4. **Select JDK**: Set the path to the Java Development Kit (JDK) in the project settings of your IDE.

5. **Run the Main Method**: Locate the **main** class and run main method ,using your IDE.


*DSA = Data Structures and Algorithms

Author: Martin Haronik, project idea from Hyperskill.
