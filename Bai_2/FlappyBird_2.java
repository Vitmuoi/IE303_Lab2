import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FlappyBird_2 extends JPanel implements ActionListener, KeyListener {
    int boardWidth = 360;
    int boardHeight = 640;
    Image backgroundImg;
    Image birdImg;

    int birdX = boardWidth / 8;
    int birdY = boardHeight / 2;
    int birdWidth = 34;
    int birdHeight = 24;

    class Bird {
        int x = birdX;
        int y = birdY;
        int width = birdWidth;
        int height = birdHeight;
        Image img;

        Bird(Image img) {
            this.img = img;
        }
    }

    Bird bird;
    int velocityY = 0;
    int gravity = 1;

    Timer gameloop;

    FlappyBird_2() {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setFocusable(true);
        addKeyListener(this);

        backgroundImg = new ImageIcon(getClass().getResource("./flappybirdbg.png")).getImage();
        birdImg = new ImageIcon(getClass().getResource("./flappybird.png")).getImage();

        bird = new Bird(birdImg);

        gameloop = new Timer(1000 / 60, this);
        gameloop.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);
        g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);
    }

    public void move() {
        velocityY += gravity;
        bird.y += velocityY;

        // Đảm bảo chim không rớt ra ngoài màn hình
        bird.y = Math.max(bird.y, 0);
        bird.y = Math.min(bird.y, boardHeight - bird.height);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == (KeyEvent.VK_SPACE) || e.getKeyCode() == KeyEvent.VK_ENTER) {
            velocityY = -8;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird 2");
        FlappyBird_2 gamePanel = new FlappyBird_2();

        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
