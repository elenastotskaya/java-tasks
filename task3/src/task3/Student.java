package task3;

public class Student {
    private final int checkUnit = 5;
    private final int number;
    private final String subject;
    private int labsCount;
    private static int totalCount = 0;
    public Student (String subject, int labsCount) {
        this.subject = subject;
        this.labsCount = labsCount;
        ++totalCount;
        this.number = totalCount;
    }

    public int getNumber() {
        return number;
    }

    public String getSubject() {
        return subject;
    }

    public int getLabsCount() {
        return labsCount;
    }

    public void checkLabs() {
        labsCount -= checkUnit;
    }
}
