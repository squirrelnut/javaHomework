package ru.stqa.pft.point;

public class Point {
   public double x, y;

   public Point(double x, double y) {
       this.x = x;
       this.y = y;
   }

    public double distance(Point p2){
        double x = (p2.x - this.x) * (p2.x - this.x);
        double y = (p2.y - this.y) * (p2.y - this.y);
        double root = Math.sqrt(x + y);

        return  root;
    }
}
