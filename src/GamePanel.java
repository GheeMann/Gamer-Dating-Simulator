import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GamePanel extends JPanel {
    private GamerDatingSimGUI frame;
    private JTextArea dialogue;
    private JPanel choicePanel;
    private int charm;

    private JLabel portraitLabel = new JLabel();
    private JLabel backgroundLabel = new JLabel();
    private JLabel charmDisplay = new JLabel();
    private ImageIcon loveBotPortrait = new ImageIcon("assets/love_bot_portrait.png");
    private Map<String, ImageIcon> characterPortraits;
    private Map<String, String[]> characterDialogue;

    public GamePanel(GamerDatingSimGUI frame) {
        this.frame = frame;
        this.charm = 0;
        setLayout(null);

        // Background
        backgroundLabel.setBounds(0, 0, 1000, 700);
        backgroundLabel.setIcon(new ImageIcon("assets/background_gameplay.png"));
        add(backgroundLabel);
        backgroundLabel.setLayout(null);

        // Portrait
        portraitLabel.setBounds(30, 300, 200, 300);
        portraitLabel.setIcon(loveBotPortrait);
        backgroundLabel.add(portraitLabel);

        // Dialogue
        dialogue = new JTextArea();
        dialogue.setWrapStyleWord(true);
        dialogue.setLineWrap(true);
        dialogue.setEditable(false);
        dialogue.setFont(new Font("Courier New", Font.PLAIN, 16));
        dialogue.setBackground(Color.BLACK);
        dialogue.setForeground(Color.WHITE);
        JScrollPane scroll = new JScrollPane(dialogue);
        scroll.setBounds(250, 400, 700, 120);
        backgroundLabel.add(scroll);

        // Choices
        choicePanel = new JPanel();
        choicePanel.setLayout(new GridLayout(0, 1, 5, 5));
        choicePanel.setBounds(650, 50, 300, 300);
        backgroundLabel.add(choicePanel);

        // Charm hidden display
        charmDisplay.setBounds(850, 630, 130, 30);
        charmDisplay.setFont(new Font("Courier New", Font.PLAIN, 12));
        charmDisplay.setForeground(new Color(0, 0, 0, 0)); // Fully transparent
        backgroundLabel.add(charmDisplay);

        characterPortraits = new HashMap<>();
        characterPortraits.put("Alex", new ImageIcon("assets/alex_portrait.png"));
        characterPortraits.put("Jamie", new ImageIcon("assets/jamie_portrait.png"));
        characterPortraits.put("Kai", new ImageIcon("assets/kai_portrait.png"));
        characterPortraits.put("Rico", new ImageIcon("assets/rico_portrait.png"));

        characterDialogue = new HashMap<>();
        characterDialogue.put("Alex", new String[]{"Yo, you actually came! Impressive.", "Heh, let's see if your strat game is as good as your pick-up lines."});
        characterDialogue.put("Jamie", new String[]{"Oh... hi. I didn’t expect company.", "You're... different. But not in a bad way."});
        characterDialogue.put("Kai", new String[]{"Sup. You here to challenge the champ?", "Better keep up, I don’t wait for slow players."});
        characterDialogue.put("Rico", new String[]{"Hi there! I brought snacks. You like snacks?", "Don't worry, I won't bite... unless you want me to."});

        showLoveBotIntro();
    }

    private void showLoveBotIntro() {
        backgroundLabel.setIcon(new ImageIcon("assets/background_lovebot.png"));
        portraitLabel.setIcon(loveBotPortrait);
        dialogue.setText("Love Bot: Welcome, repulsive nerd! Ready to disgrace yourself in the name of love?");
        choicePanel.removeAll();

        String[] choices = {
            "Yes, master of cringe!",
            "Guide me, digital romance guru.",
            "I’m desperate and alone, help.",
            "Please bless me with dating knowledge!",
            "Let’s get this disaster started!",
            "Is it too late to uninstall feelings?"
        };

        for (String choice : choices) {
            JButton btn = new JButton("💖 " + choice);
            btn.setBackground(new Color(255, 105, 180));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
            btn.addActionListener(e -> proceedToDates());
            choicePanel.add(btn);
        }

        revalidate();
        repaint();
    }

    private void proceedToDates() {
        backgroundLabel.setIcon(new ImageIcon("assets/background_selection.png"));
        dialogue.setText("Love Bot: Choose your pixelated fate, brave (and gross) adventurer!");
        choicePanel.removeAll();

        String[] dates = {"Alex", "Jamie", "Kai", "Rico"};

        for (String date : dates) {
            JButton btn = new JButton("???");
            btn.setBackground(Color.CYAN);
            btn.setForeground(Color.BLACK);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.setToolTipText("Click to date " + date);
            btn.addActionListener(e -> startDate(date));
            choicePanel.add(btn);
        }

        revalidate();
        repaint();
    }

    private void startDate(String dateName) {
        backgroundLabel.setIcon(new ImageIcon("assets/background_" + dateName.toLowerCase() + ".png"));
        dialogue.setText("You nervously approach " + dateName + "...\n" + characterDialogue.get(dateName)[0]);
        portraitLabel.setIcon(characterPortraits.get(dateName));
        choicePanel.removeAll();

        String[] options = {
            "Give a heartfelt compliment",
            "Talk about your game rank",
            "Make a meme joke",
            "Compare them to your favorite character"
        };

        for (String option : options) {
            JButton btn = new JButton(option);
            btn.setBackground(Color.MAGENTA);
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Arial", Font.BOLD, 16));
            btn.addActionListener(e -> handleDateResponse(option, dateName));
            choicePanel.add(btn);
        }

        revalidate();
        repaint();
    }

    private void handleDateResponse(String choice, String dateName) {
        String reply = characterDialogue.get(dateName)[1];
        if (choice.contains("compliment")) {
            dialogue.setText(reply + "\nThey smile. That’s rare. Did you level up in charm?");
            charm += 10;
        } else if (choice.contains("rank")) {
            dialogue.setText(reply + "\nThey nod. Respecting your grind. A cautious win.");
            charm += 5;
        } else if (choice.contains("meme")) {
            dialogue.setText(reply + "\nThey blink slowly. They didn't get the meme.");
            charm -= 5;
        } else {
            dialogue.setText(reply + "\nThey laugh. That was unexpected, but kind of sweet.");
            charm += 7;
        }

        charmDisplay.setText("Charm: " + charm);

        if (charm >= 20) {
            showCongratulations(dateName);
        } else if (charm <= -10) {
            gameOver(false);
        }
    }

    private void gameOver(boolean win) {
        charm = 0;
        choicePanel.removeAll();
        portraitLabel.setIcon(loveBotPortrait);
        backgroundLabel.setIcon(new ImageIcon("assets/background_gameover.png"));
        dialogue.setText("Love Bot: Yikes. That went worse than a lag spike in a tournament. Try again, maybe shower first.");

        JButton restart = new JButton("Try Again?");
        restart.setBackground(Color.ORANGE);
        restart.setFont(new Font("Arial", Font.BOLD, 16));
        restart.addActionListener(e -> {
            charm = 0;
            backgroundLabel.setIcon(new ImageIcon("assets/background_gameplay.png"));
            showLoveBotIntro();
        });
        choicePanel.add(restart);
        revalidate();
        repaint();
    }

    private void showCongratulations(String characterName) {
        charm = 0;
        choicePanel.removeAll();
        portraitLabel.setIcon(characterPortraits.get(characterName));
        backgroundLabel.setIcon(new ImageIcon("assets/background_win.png"));
        dialogue.setText(characterName + ": Wow... I didn’t expect this, but I think I really like you. Let’s go play co-op together.\n\nLove Bot: WHAT?! You actually won?! GGs, nerd. Touch some grass.");

        JButton restart = new JButton("Play Again?");
        restart.setBackground(new Color(144, 238, 144));
        restart.setFont(new Font("Arial", Font.BOLD, 16));
        restart.addActionListener(e -> {
            charm = 0;
            backgroundLabel.setIcon(new ImageIcon("assets/background_gameplay.png"));
            showLoveBotIntro();
        });
        choicePanel.add(restart);
        revalidate();
        repaint();
    }
}
