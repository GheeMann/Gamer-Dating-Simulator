import javax.swing.*;
import java.awt.*;

public class GamerDatingSimGUI extends JFrame {
    public GamerDatingSimGUI() {
        setTitle("Gamer Dating Simulator");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayout(new CardLayout());

        GamePanel gamePanel = new GamePanel(this);
        add(gamePanel, "Game");

        setVisible(true);
    }
}