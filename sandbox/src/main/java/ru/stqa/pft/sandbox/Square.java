package ru.stqa.pft.sandbox;

public class Square {
    public double l;

    public Square(double q) {
        this.l = q;
    }

    public double area() {
        return this.l * this.l;
    }
}
