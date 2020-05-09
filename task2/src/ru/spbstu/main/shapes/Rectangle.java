package ru.spbstu.main.shapes;

/**
 * Представление о прямоугольнике.
 * <p>
 * Прямоугольник — четырехугольник, у которого все углы
 * прямые (равны 90 градусам).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D1%8F%D0%BC%D0%BE%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA">Прямоугольник</a>
 */
public class Rectangle implements Polygon {

    private Dot point1;
    private Dot point2;
    private Dot point3;
    private Dot point4;
    private float width;
    private float height;
    private int rotation;

    public Rectangle(Dot point1, float width, float height, int rotation) {
        if (width > 0 && height > 0) {
            this.point1 = point1;
            this.width = width;
            this.height = height;
            this.rotation = rotation;
            this.point2 = new Dot(point1.x + width, point1.y);
            this.point3 = new Dot(point1.x + width, point1.y + height);
            this.point4 = new Dot(point1.x, point1.y + height);
            this.point2 = getRotatedCoordinates(this.point1, this.point2, rotation);
            this.point3 = getRotatedCoordinates(this.point1, this.point3, rotation);
            this.point4 = getRotatedCoordinates(this.point1, this.point4, rotation);
        } else {
            throw new RuntimeException("Negative width or height");
        }
    }

    public Rectangle(Dot point1, Dot point2, Dot point3, Dot point4) {
        if (Dot.getDistance(point1, point3) == Dot.getDistance(point2, point4) && (point1.x + point3.x)/2 == (point2.x + point4.x)/2 && (point1.y + point3.y)/2 == (point2.y + point4.y)/2){
            this.width = Dot.getDistance(point1, point2);
            this.height = Dot.getDistance(point1, point4);
        } else {
            throw new RuntimeException("Not a rectangle");
        }
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        this.point4 = point4;
        this.rotation = Dot.getAngle(point1, point2);
    }

    private Dot getRotatedCoordinates(Dot ref, Dot dot, int rotation) {
        double rotationRadians = rotation * Math.PI / 180;
        float x = (float)((dot.x - ref.x) * Math.cos(rotationRadians) - (dot.y - ref.y) * Math.sin(rotationRadians) + ref.x);
        float y = (float)((dot.x - ref.x) * Math.sin(rotationRadians) + (dot.y - ref.y) * Math.cos(rotationRadians) + ref.y);
        return new Dot(x, y);
    }

    @Override
    public float getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public float getArea() {
        return width * height;
    }

    @Override
    public int getRotation() {
        return rotation;
    }

    /*
     * TODO: Реализовать класс 'Rectangle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
}
