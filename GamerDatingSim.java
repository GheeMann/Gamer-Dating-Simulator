import java.util.Scanner;

public class GamerDatingSim {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🎮 Welcome to the Gamer Dating Sim!");
        System.out.print("What's your name? ");
        String playerName = scanner.nextLine();

        System.out.println("\nHi " + playerName + "! You have two people interested in you:");
        System.out.println("1. Alex - funny, outgoing, and loves memes.");
        System.out.println("2. Jamie - quiet, mysterious, and writes poetry.");
        System.out.print("Who would you like to talk to? (Enter 1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // clear newline

        if (choice == 1) {
            talkToAlex(scanner);
        } else if (choice == 2) {
            talkToJamie(scanner);
        } else {
            System.out.println("\nYou decided to go home and play video games alone. Classic gamer move!");
        }

        System.out.println("\nThanks for playing, " + playerName + "!");
        System.out.println("🎮 Game Over.");
        System.out.println("👀 Wanna try again and maybe not bomb it this time?");
        
        scanner.close();
    }

    public static void talkToAlex(Scanner scanner) {
        System.out.println("\n🎤 You approach Alex at the arcade.");
        System.out.println("Alex: Yo! You play any games?");
        System.out.println("1. Yeah! I love co-op games.");
        System.out.println("2. Not really, I prefer watching memes.");
        System.out.println("3. I'm more into single-player RPGs.");
        System.out.print("Your choice: ");
        int response = scanner.nextInt();
        scanner.nextLine();

        switch (response) {
            case 1:
                System.out.println("Alex: Co-op? Let's team up sometime! Bet we’d make a great duo.");
                break;
            case 2:
                System.out.println("Alex: Memes are life. Do you know the one with the dog in a burning house?");
                System.out.print("Respond with 'yes' or 'no': ");
                String memeReply = scanner.nextLine().toLowerCase();
                if (memeReply.equals("yes")) {
                    System.out.println("Alex: Haha! ‘This is fine.’ You're cool.");
                } else {
                    System.out.println("Alex: What?! I need to show it to you ASAP.");
                }
                break;
            case 3:
                System.out.println("Alex: Ah, a lone wolf! That’s kind of hot.");
                break;
            default:
                System.out.println("Alex: Um... okay?");
        }

        System.out.println("Alex: Wanna grab bubble tea and talk more?");
        System.out.println("1. Definitely!");
        System.out.println("2. Maybe later.");
        System.out.print("Your choice: ");
        int bubbleTea = scanner.nextInt();

        if (bubbleTea == 1) {
            System.out.println("Alex: Sweet! Let’s go!");
        } else {
            System.out.println("Alex: Cool, maybe next time.");
            System.out.println("*Alex walks away with a shrug.*");
            System.out.println("💔 Oof. That didn’t go so well.");
            System.out.println("💬 Tip: Maybe compliment their arcade skills next time?");
        }
        
    }

    public static void talkToJamie(Scanner scanner) {
        System.out.println("\n📖 You find Jamie sketching alone at a café.");
        System.out.println("Jamie: Hi. Do you enjoy the quiet, or does it make you nervous?");
        System.out.println("1. I love the peace and calm.");
        System.out.println("2. Honestly, silence can be awkward.");
        System.out.println("3. Only when it’s not shared.");
        System.out.print("Your choice: ");
        int response = scanner.nextInt();
        scanner.nextLine();

        switch (response) {
            case 1:
                System.out.println("Jamie: Same. The world is too loud sometimes.");
                break;
            case 2:
                System.out.println("Jamie: I used to feel that too. Now I find comfort in it.");
                break;
            case 3:
                System.out.println("Jamie: That’s… a beautiful answer.");
                break;
            default:
                System.out.println("Jamie: Hmm. You’re hard to read.");
        }

        System.out.println("Jamie: Would you like to hear a poem I wrote?");
        System.out.println("1. I’d love to.");
        System.out.println("2. Maybe another time.");
        System.out.print("Your choice: ");
        int poemChoice = scanner.nextInt();

        if (poemChoice == 1) {
            System.out.println("Jamie: ‘The stars fall slowly into coffee cups...’");
            System.out.println("Jamie: Thank you for listening.");
        } else {
            System.out.println("Jamie: That’s okay. Art should be shared when it’s welcomed.");
            System.out.println("*Jamie quietly turns back to her sketchbook.*");
            System.out.println("💔 Welp. That could’ve gone better.");
            System.out.println("💬 Next time, maybe show some mysterious poet energy?");
        }
        
    }
}
