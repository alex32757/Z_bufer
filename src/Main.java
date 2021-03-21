import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends JComponent {
    public ArrayList<Figure> figures = new ArrayList<>();
    public static Window window = new Window();

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D drp = (Graphics2D) g;
        for (Figure figure : figures) {
            figure.paint(drp);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Лабораторная 5");
        final Main comp = new Main();
        comp.setPreferredSize(new Dimension(600, 400));
        frame.getContentPane().add(comp, BorderLayout.CENTER);
        JPanel buttonsPanel = new JPanel();
        JButton renderButton = new JButton("Render");
        buttonsPanel.add(renderButton);
        frame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
        buttonsPanel.setBackground(Color.blue);

        renderButton.addActionListener(e -> {
            //tetrahedron 1
            Point p11 = new Point(100, 200, 320);
            Point p12 = new Point(180, 50, 280);
            Point p13 = new Point(260, 150, 210);
            Point p14 = new Point(280, 220, 500);

            //tetrahedron 2
            Point p21 = new Point(100, 100, 100);
            Point p22 = new Point(450, 60, 100);
            Point p23 = new Point(400, 90, 250);//
            Point p24 = new Point(500, 200, 110);

            Tetra tetra1 = new Tetra(p11, p12, p13, p14, Color.MAGENTA, Color.green, Color.CYAN, Color.blue);
            Tetra tetra2 = new Tetra(p21, p22, p23, p24, Color.PINK, Color.orange, Color.gray, Color.red);
            comp.figures.add(tetra1);
            comp.figures.add(tetra2);

            comp.repaint();

        });

        frame.pack();
        frame.setVisible(true);
    }
}
