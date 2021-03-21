import java.awt.*;

public class Triangle {
    protected Point p1;
    protected Point p2;
    protected Point p3;
    protected Color color;
    protected int a;
    protected int b;
    protected int c;
    protected int d;

    public Triangle(Point p1, Point p2, Point p3, Color color) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.color = color;

        int a1 = p2.x - p1.x;
        int b1 = p2.y - p1.y;
        int c1 = p2.z - p1.z;
        int a2 = p3.x - p1.x;
        int b2 = p3.y - p1.y;
        int c2 = p3.z - p1.z;
        this.a = b1 * c2 - b2 * c1;
        this.b = a2 * c1 - a1 * c2;
        this.c = a1 * b2 - b1 * a2;

        this.d = (- a * p1.x - b * p1.y - c * p1.z);

        System.out.println("equation of plane is " + a +
                " x + " + b + " y + " + c + " z + " + d + " = 0");

    }

    static double computeSquare(Point p1, Point p2, Point p3) {
        return Math.abs(0.5 * ((p1.x - p3.x) * (p2.y - p3.y) -
                (p2.x - p3.x) * (p1.y - p3.y)));
    }

    int computeZ(int x, int y) {
        return  (int)-(((double)a * (double)x / (double)c) +  ((double)b * (double)y / (double)c) + (double)d / (double)c);
    }

    boolean checkToVertex(int x, int y) {
        if(p1.x == x && p1.y == y)
            return true;
        if(p2.x == x && p2.y == y)
            return true;
        if(p3.x == x && p3.y == y)
            return true;

        return false;
    }
}
