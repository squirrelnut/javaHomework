package ru.stqa.pft.point;
import org.testng.Assert;
import org.testng.annotations.Test;
import static ru.stqa.pft.point.Main.distance;

public class PointTests {

    @Test
    public void testDistance(){
        Point first = new Point(1.3,2.4);
        Point second = new Point(2.1, 3.0);
        Assert.assertEquals(distance(first,second),1.0); //Проверка функции
        Assert.assertEquals(first.distance(second), 1.0);//Проверка метода
        Assert.assertEquals(second.distance(first), 1.0);//Проверка метода
    }
}
