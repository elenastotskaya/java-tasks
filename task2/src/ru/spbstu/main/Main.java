package ru.spbstu.main;

import ru.spbstu.main.shapes.*;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];
        shapes[0] = new Rectangle(new Dot(1.0f, 10.0f), 5.0f, 5.0f, 90);
        shapes[1] = new Circle(new Dot(-2.5f, 10.0f), 3.0f);
        shapes[2] = new Triangle(new Dot(1.0f, 0.0f), new Dot(8.0f, 1.5f), new Dot(6.0f, -2.0f));
        shapes[3] = new Circle(new Dot(12.0f, 4.0f), 5.0f);
        shapes[4] = new Rectangle(new Dot(1.0f, 6.5f), new Dot(5.0f, 6.5f), new Dot(5.0f, 0.0f), new Dot(1.0f, 0.0f));
        shapes[5] = new Rectangle(new Dot(3.0f, 4.0f), 10.0f, 4.0f, 30);
        shapes[6] = new Triangle(new Dot(-2.0f, -4.0f), new Dot(1.0f, 2.5f), new Dot(5.0f, -2.0f));
        shapes[7] = new Circle(new Dot(4.5f, -2.0f), 1.5f);
        shapes[8] = new Triangle(new Dot(1.0f, 3.0f), new Dot(3.5f, 2.5f), new Dot(2.0f, -0.5f));
        shapes[9] = new Rectangle(new Dot(-3.0f, 1.5f), new Dot(3.0f, 1.5f), new Dot(3.0f, -0.5f), new Dot(-3.0f, -0.5f));
        Shape maxShape = findMaxArea(shapes);
        System.out.print(maxShape.getArea() + " " + maxShape.getClass().getSimpleName());

        /*
         * TODO: Выполнить действия над массивом 'shapes'
         *
         * 1. Проинициализировать переменную 'shapes' массивом
         *    содержащим 10 произвольных фигур. Массив должен
         *    содержать экземпляры классов Circle, Rectangle
         *    и Triangle.
         *
         * 2. Найти в массиве 'shapes' фигуру с максимальной
         *    площадью. Для поиска фигуры необходимо создать
         *    статический метод в текущем классе (Main).
         */
    }

    private static Shape findMaxArea(Shape [] shapes) {
        if (shapes.length == 0) {
            throw new RuntimeException("Array is empty");
        }
        float maxArea = 0.0f;
        Shape maxShape = null;
        for (Shape shape: shapes) {
            if (shape.getArea() > maxArea) {
                maxShape = shape;
                maxArea = shape.getArea();
            }
        }
        return maxShape;
    }
}
