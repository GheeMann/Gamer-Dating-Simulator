import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GamerDatingSimGUI extends JFrame {

    public GamerDatingSimGUI() {
        setTitle("Gamer Dating Sim");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        showMainMenu();
    }

    public void showMainMenu() {
        setContentPane(new MainMenuPanel(this));
        revalidate();
        repaint();
    }

    public void showDialogue(Character character) {
        setContentPane(new DialoguePanel(this, character));
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            UIManager.put("Button.font", new Font("Comic Sans MS", Font.BOLD, 14));
            UIManager.put("Label.font", new Font("Comic Sans MS", Font.PLAIN, 16));
            UIManager.put("TextArea.font", new Font("Comic Sans MS", Font.PLAIN, 16));
            UIManager.put("Panel.background", new Color(255, 228, 140));
            UIManager.put("Button.background", new Color(255, 105, 180));
            UIManager.put("Button.foreground", Color.WHITE);
            UIManager.put("Button.border", BorderFactory.createLineBorder(new Color(255, 69, 0), 2));
            
            GamerDatingSimGUI game = new GamerDatingSimGUI();
            game.setVisible(true);
        });
    }
}
