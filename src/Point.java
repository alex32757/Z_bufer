import java.awt.*;

public class Point implements Figure{
    protected int x;
    protected int y;
    protected int z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(Point d) {
        this(d.getX(), d.getY(), d.getZ());
    }

    @Override
    public void paint(Graphics2D g) {
        g.fillOval(x - 1, y - 1, 2, 2);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
