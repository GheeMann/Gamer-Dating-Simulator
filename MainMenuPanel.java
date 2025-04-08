import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainMenuPanel extends JPanel {

    public MainMenuPanel(GamerDatingSimGUI game) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("🎮 Gamer Dating Sim", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));

        buttonPanel.add(createOptionButton(game, new Character("Alex", "Funny, outgoing, loves memes.", "assets/alex.png")));
        buttonPanel.add(createOptionButton(game, new Character("Jamie", "Quiet, mysterious, writes poetry.", "assets/jamie.png")));
        buttonPanel.add(createOptionButton(game, new Character("Kai", "Chill skater gamer who vibes with lo-fi.", "assets/kai.png")));
        buttonPanel.add(createOptionButton(game, new Character("Rico", "Confident, flirty streamer with big energy.", "assets/rico.png")));

        add(buttonPanel, BorderLayout.CENTER);
    }

    private JButton createOptionButton(GamerDatingSimGUI game, Character character) {
        JButton button = new JButton(character.getName() + " - " + character.getDescription());
        button.addActionListener((ActionEvent e) -> game.showDialogue(character));
        return button;
    }
}
