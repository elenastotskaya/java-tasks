package task3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Phaser;

public class Robot implements Runnable {
    private static final Phaser phaser = new Phaser(3);
    private ArrayBlockingQueue<Student> students;
    private Student currentStudent = null;
    private final String subject;
    public Robot(ArrayBlockingQueue<Student> students, String subject) {
        this.students = students;
        this.subject = subject;
    }

    @Override
    public void run() {
        try {
            while (true) {
                currentStudent = students.peek();
                if (currentStudent != null) {
                    if (currentStudent.getSubject().equals(subject)) {
                        currentStudent = students.take();
                        phaser.arrive();
                        while (currentStudent.getLabsCount() != 0) {
                            System.out.println("Checking " + subject + " labs of student " + currentStudent.getNumber() + ", " + currentStudent.getLabsCount() + " labs left");
                            currentStudent.checkLabs();;
                        }
                        System.out.println("Finished checking labs of student " + currentStudent.getNumber());
                    } else if (currentStudent.getSubject().equals("End")) {
                        phaser.arriveAndDeregister();
                        break;
                    }
                }
                phaser.arriveAndAwaitAdvance();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
