import java.awt.*;
import java.util.ArrayList;

public class Tetra implements Figure{
    ArrayList<Triangle> planes = new ArrayList<>();

    public Tetra(Point p1, Point p2, Point p3, Point p4, Color color1, Color color2, Color color3, Color color4) {
        planes.add(new Triangle(p1, p2, p3, color1));
        planes.add(new Triangle(p1, p3, p2, color2));
        planes.add(new Triangle(p1, p2, p4, color3));
        planes.add(new Triangle(p2, p3, p4, color4));
    }

    @Override
    public void paint(Graphics2D g) {
        for(Triangle plane : planes)
            Main.window.updateBuffer(plane);

        for (int i = 0; i < 600; i++) {
            for (int j = 0; j < 400; j++) {
                g.setColor(Main.window.frameBuffer[i][j]);
                g.fillRect(i, j, 1, 1);
            }
        }
    }
}
