import java.awt.*;

public class Window {
    protected Color[][] frameBuffer = new Color[600][400];
    protected int[][] zBuffer = new int[600][400];

    public Window() {
        for(int i = 0; i < 600; i++)
            for (int j = 0; j < 400; j++) {
                frameBuffer[i][j] = Color.lightGray;
                zBuffer[i][j] = 0;
            }
    }

    public void clear() {
        for(int i = 0; i < 600; i++)
            for (int j = 0; j < 400; j++) {
                frameBuffer[i][j] = Color.lightGray;
                zBuffer[i][j] = 0;
            }
    }

    boolean check(Triangle triangle, Point point) {
        double mainSquare = Triangle.computeSquare(triangle.p1, triangle.p2, triangle.p3);
        double square1 = Triangle.computeSquare(triangle.p1, triangle.p2, point);
        double square2 = Triangle.computeSquare(triangle.p1, triangle.p3, point);
        double square3 = Triangle.computeSquare(triangle.p2, triangle.p3, point);

        return mainSquare == (square1 + square2 + square3);
    }

    public void updateBuffer(Triangle triangle) {
        for(int i = 0; i < 600; i++) {
            for (int j = 0; j < 400; j++) {
                if (check(triangle, new Point(i, j, 0))) {
                    if (triangle.computeZ(i, j) >= zBuffer[i][j]) {
                        if (triangle.checkToVertex(i, j)) {
                            for (int k = i - 1; k <= i + 1; k++)
                                for(int l = j - 1; l <= j + 1; l++) {
                                    frameBuffer[k][l] = Color.black;
                                }
                        }
                        else {
                            zBuffer[i][j] = triangle.computeZ(i, j);
                            frameBuffer[i][j] = triangle.color;
                        }
                    }
                }
            }
        }
    }
}
