package ru.stqa.pft.point;

public class Main {
    public static void main(String[] args) {
        //Решение через функцию
        Point first = new Point(2.5, 1.9);
        Point second = new Point(3.3, 2.4);
        System.out.println("Расстояние между точкой (" + first.x + ";" + first.y +
                ") и точкой (" + second.x + ";" + second.y + ") = " + distance(first, second));


        //Решение через метод класса Point
        System.out.println("Расстояние между точкой (" + first.x + ";" + first.y +
                ") и точкой (" + second.x + ";" + second.y + ") = " + first.distance(second));

        System.out.println("Расстояние между точкой (" + first.x + ";" + first.y +
                ") и точкой (" + second.x + ";" + second.y + ") = " + second.distance(first));
    }

    public static double distance(Point p1, Point p2){
        double x = (p2.x - p1.x) * (p2.x - p1.x);
        double y = (p2.y - p1.y) * (p2.y - p1.y);
        double root = Math.sqrt(x + y);

        return  root;
    }
}
