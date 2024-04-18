package Exceptions;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Create instances of Student, Course, and Enrollment
        Student student = new Student(1, "John Doe", 20);
        Course course = new Course("CS101", "Introduction to Programming", "Dr. Smith");
        Enrollment enrollment = new Enrollment(student, course, "2023-04-20");

        // Serialize and save the Enrollment instance
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("enrollments.ser"))) {
            outputStream.writeObject(enrollment);
            System.out.println("Enrollment object serialized and saved to enrollments.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize and print the Enrollment instance
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("enrollments.ser"))) {
            Enrollment deserializedEnrollment = (Enrollment) inputStream.readObject();
            System.out.println("Deserialized Enrollment object:");
            System.out.println(deserializedEnrollment);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
