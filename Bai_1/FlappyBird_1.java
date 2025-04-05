import java.awt.*;
import javax.swing.*;

public class FlappyBird_1 extends JPanel {
    int boardWidth = 360;
    int boardHeight = 640;
    Image backgroundImg;

    FlappyBird_1() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");
        FlappyBird_1 gamePanel = new FlappyBird_1();

        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}