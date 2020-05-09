package ru.spbstu.main.shapes;

public class Dot implements Point {
    float x, y;

    public Dot(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

    public static float getDistance(Dot point1, Dot point2) {
        return (float) Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
    }

    public static int getAngle(Dot point1, Dot point2) {
        int angle = (int) (Math.asin(Dot.getDistance(point2, new Dot(point2.x, point1.y)) * 180 / Math.PI));
        if (point1.x > point2.x) {
            if (point1.y > point2.y) {
                angle += 180;
            } else {
                angle = 180 - angle;
            }
        } else if (point1.y > point2.y) {
            angle = 360 - angle;
        }
        return angle;
    }
}
