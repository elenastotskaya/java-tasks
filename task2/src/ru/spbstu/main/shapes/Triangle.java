package ru.spbstu.main.shapes;

/**
 * Представление о треугольнике.
 * <p>
 * Треуго́льник (в евклидовом пространстве) — геометрическая
 * фигура, образованная тремя отрезками, которые соединяют
 * три точки, не лежащие на одной прямой. Указанные три
 * точки называются вершинами треугольника, а отрезки —
 * сторонами треугольника. Часть плоскости, ограниченная
 * сторонами, называется внутренностью треугольника: нередко
 * треугольник рассматривается вместе со своей внутренностью
 * (например, для определения понятия площади).
 *
 * @see <a href="https://ru.wikipedia.org/wiki/%D0%A2%D1%80%D0%B5%D1%83%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D0%B8%D0%BA">Треугольник</a>
 */
public class Triangle implements Polygon {

    private Dot point1;
    private Dot point2;
    private Dot point3;
    private float side1;
    private float side2;
    private float side3;
    private int rotation;

    public Triangle(Dot point1, Dot point2, Dot point3) {
        if (Dot.getDistance(point1, point2) + Dot.getDistance(point2, point3) > Dot.getDistance(point3, point1) &&
           Dot.getDistance(point2, point3) + Dot.getDistance(point3, point1) > Dot.getDistance(point1, point2) &&
              Dot.getDistance(point3, point1) + Dot.getDistance(point1, point2) > Dot.getDistance(point2, point3)) {
            this.point1 = point1;
            this.point2 = point2;
            this.point3 = point3;
            this.side1 = Dot.getDistance(point1, point2);
            this.side2 = Dot.getDistance(point2, point3);
            this.side3 = Dot.getDistance(point3, point1);
            this.rotation = Dot.getAngle(point1, point2);
        } else {
            throw new RuntimeException("Not a triangle");
        }
    }

    @Override
    public float getArea() {
        float p = (side1 + side2 + side3) / 2;
        return (float) Math.sqrt((p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public float getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public int getRotation() {
        return rotation;
    }

    /*
     * TODO: Реализовать класс 'Triangle'
     * 1. Используйте наследование.
     * 2. Реализуйте все абстрактные методы.
     */
}
