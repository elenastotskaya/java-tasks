package task3;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final int roomSize = 10;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentCount = 0;
        System.out.println("Enter number of students");
        while(studentCount <= 0) {
            try {
                studentCount = scanner.nextInt();
                if (studentCount <= 0) {
                    System.out.println("Incorrect number of students");
                }
            } catch (InputMismatchException e) {
                System.out.println("Incorrect number of students");
            }
        }
        ArrayBlockingQueue<Student> students = new ArrayBlockingQueue<Student>(roomSize);
        ExecutorService threads = Executors.newFixedThreadPool(4);
        Generator generator = new Generator(students, studentCount);
        Robot mathRobot = new Robot(students, "Math");
        Robot oopRobot = new Robot(students, "OOP");
        Robot physicsRobot = new Robot(students, "Physics");
        threads.execute(generator);
        threads.execute(mathRobot);
        threads.execute(oopRobot);
        threads.execute(physicsRobot);
        threads.shutdown();
    }
}
