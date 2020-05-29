package task3;

import java.util.concurrent.ArrayBlockingQueue;

public class Generator implements Runnable {
    private ArrayBlockingQueue<Student> students;
    private int lineSize;

    public Generator(ArrayBlockingQueue<Student> students, int lineSize) {
        this.students = students;
        this.lineSize = lineSize;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < lineSize; ++i) {
                students.put(new Student(generateSubject(), generateLabsCount()));
            }
            students.put(new Student("End", 0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String generateSubject() {
        int index = (int) (Math.random() * 3);
        String subject;
        switch (index) {
            case 0:
                subject = "Math";
                break;
            case 1:
                subject = "OOP";
                break;
            default:
                subject = "Physics";
        }
        return subject;
    }

    private int generateLabsCount() {
        int index = (int) (Math.random() * 3);
        int labsCount;
        switch (index) {
            case 0:
                labsCount = 10;
                break;
            case 1:
                labsCount = 20;
                break;
            default:
                labsCount = 100;
        }
        return labsCount;
    }
}
