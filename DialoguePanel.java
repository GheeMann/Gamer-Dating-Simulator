import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DialoguePanel extends JPanel {

    private GamerDatingSimGUI game;
    private Character character;
    private JTextArea dialogueArea;
    private int stage = 0;
    private JLabel portraitLabel;

    public DialoguePanel(GamerDatingSimGUI game, Character character) {
        this.game = game;
        this.character = character;
        setLayout(new BorderLayout());

        dialogueArea = new JTextArea();
        dialogueArea.setEditable(false);
        dialogueArea.setLineWrap(true);
        dialogueArea.setWrapStyleWord(true);
        dialogueArea.setFont(new Font("SansSerif", Font.PLAIN, 16));
        add(new JScrollPane(dialogueArea), BorderLayout.CENTER);

        // Add character portrait
        portraitLabel = new JLabel(new ImageIcon(character.getPortraitPath()));
        add(portraitLabel, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel();
        JButton choice1 = new JButton("Choice 1");
        JButton choice2 = new JButton("Choice 2");

        buttonPanel.add(choice1);
        buttonPanel.add(choice2);
        add(buttonPanel, BorderLayout.SOUTH);

        updateDialogue();

        choice1.addActionListener((ActionEvent e) -> handleChoice(1));
        choice2.addActionListener((ActionEvent e) -> handleChoice(2));
    }

    private void updateDialogue() {
        switch (character.getName()) {
            case "Alex":
                if (stage == 0)
                    dialogueArea.setText("Alex: Yo! You play any games?");
                else if (stage == 1)
                    dialogueArea.setText("Alex: Co-op games? We’d crush together. Wanna get bubble tea?");
                break;

            case "Jamie":
                if (stage == 0)
                    dialogueArea.setText("Jamie: Do you enjoy the quiet, or does it make you nervous?");
                else if (stage == 1)
                    dialogueArea.setText("Jamie: Thanks for being calm. Would you like to hear a poem?");
                break;

            case "Kai":
                if (stage == 0)
                    dialogueArea.setText("Kai: Yo. You into music, skating, or gaming?");
                else if (stage == 1)
                    dialogueArea.setText("Kai: Let’s vibe on the pier sometime. Sound good?");
                break;

            case "Rico":
                if (stage == 0)
                    dialogueArea.setText("Rico: Yo, chat says you’re cute. Wanna duo stream?");
                else if (stage == 1)
                    dialogueArea.setText("Rico: Let’s grab boba and roast Twitch chat together.");
                break;
        }
    }

    private void handleChoice(int choice) {
        stage++;

        if (stage == 2) {
            if (choice == 1) {
                dialogueArea.setText(character.getName() + ": Nice! Let’s hang out more soon.");
            } else {
                dialogueArea.setText(character.getName() + ": Aight, maybe next time. No pressure.");
                dialogueArea.append("\n\n💔 That was a soft flop. Keep leveling up those charm stats!");
            }

            JButton restartButton = new JButton("Back to Menu");
            restartButton.addActionListener(e -> game.showMainMenu());
            removeAll();
            setLayout(new BorderLayout());
            add(new JScrollPane(dialogueArea), BorderLayout.CENTER);
            add(restartButton, BorderLayout.SOUTH);
            revalidate();
            repaint();
        } else {
            updateDialogue();
        }
    }
}
