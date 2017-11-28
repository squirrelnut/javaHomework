package ru.stqa.pft.sandbox;

public class World {
    public static void main(String[] args) {
        System.out.println("Hello World");



        Square kema = new Square(5);
        System.out.println("Площадь квадрата со стороной " + kema.l + " = " + kema.area());

        Rectangle igor = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника со сторонами " + igor.a + " и " + igor.b + " = " + igor.area());
    }

}