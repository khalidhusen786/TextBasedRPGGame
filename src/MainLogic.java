import java.util.Scanner;
public class MainLogic {
    static Scanner scanner = new Scanner(System.in);
    static MainPlayer player;
    public static boolean isGameRunning;
    public static String[] encreaseEncounter = {"fight", "fight", "fight", "fight", "shop", "rest"};
    public static String[] enemies = {"goblin", "thor", "tokyo", "arthur", "mike", "stephen"};
    public static int place = 0, act = 1;
    public static String[] places = {"Everlasting Mountains", "Haunted Landlines", "Castle of the Evil War", "Throne Room"};

    // to get user input
    public static int readInteger(String prompt, int userChoices) {
        int takeInput;
        do {
            System.out.println(prompt);
            try {
                takeInput = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                takeInput = -1;
                System.out.println("kindly enter an integer value!");
            }
        }
        while (takeInput < 1 || takeInput > userChoices);
        return takeInput;

    }

    //method for  clearing out the console
    public static void clearConsole() {
        for (int i = 0; i < 100; i++)
            System.out.println();
    }

    //method to print a seperat line
    public static void printSeperatLine(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("-");

        System.out.println();
    }

    //method to print a title
    public static void printTitle(String title) {
        printSeperatLine(30);
        System.out.println(title);
        printSeperatLine(30);
    }

    //method to exit the game when user enters anything
    public static void enterAnythingToContinue() {
        System.out.println("\nEnter anything to continue...");
        scanner.next();
    }


    //    method to start the game
    public static void startGame() {
        boolean nameSet = false;
        String name;
        clearConsole();
        printSeperatLine(40);
        printSeperatLine(30);
        System.out.println("EVIL WAR||");
        System.out.println("TEXT RPG GAME");
        printSeperatLine(30);
        printSeperatLine(40);
        enterAnythingToContinue();

        do {

            clearConsole();

            printTitle("Enter the player name?");

            name = scanner.next();

            clearConsole();

            printTitle("Player name is " + name + ".\nIs that correct?");
            System.out.println("(1) Yes!");

            System.out.println("(2) No, I want to change my name.");

            int input = readInteger("->", 2);

            if (input == 1)

                nameSet = true;

        } while (!nameSet);

        GameStory.printIntroStory();
        player = new MainPlayer(name);
        GameStory.printFirstActionStory();
        isGameRunning = true;
        gameLoop();


    }

    public static void checkAction() {
        if (player.xp >= 10 && act == 1) {
            act = 2;
            place = 1;
            GameStory.printFirstActionOutputStory();
            player.chooseTrait();
            GameStory.printSecondActionStory();
            enemies[0] = "Evil Mercenary";
            enemies[1] = "Goblin";
            enemies[2] = "Wolve Pack";
            enemies[3] = "Henchman of the Evil Emperor";
            enemies[4] = "Scary Stranger";
            encreaseEncounter[0] = "fight";
            encreaseEncounter[1] = "fight";
            encreaseEncounter[2] = "fight";
            encreaseEncounter[3] = "rest";
            encreaseEncounter[4] = "shop";
            player.hp = player.maxHp;
        } else if (player.xp >= 50 && act == 2) {
            act = 3;
            place = 2;
            GameStory.printSecondActionOutputStory();
            player.chooseTrait();
            GameStory.printThirdActionStory();

        } else if (player.xp > 100 && act == 3) {
            act = 4;
            place = 3;
            GameStory.printThirdActionOutputStory();
            player.chooseTrait();
            GameStory.printEndStory();
            finalBattle();
        }
    }

    public static void randomEncounter() {
        int encounter = (int) (Math.random() * encreaseEncounter.length);

        if (encreaseEncounter[encounter].equals("fight")) {
            randomBattle();

        } else if (encreaseEncounter[encounter].equals("rest")) {
            takeRest();

        } else {
            shop();

        }
    }

    public static void continueYourJourney() {
        checkAction();
        if (act != 4) {
            randomEncounter();
        }
    }

    public static void shop() {

        clearConsole();

        printTitle("You meet a mysterious stranger. He offers you something:");
        int price = (int) (Math.random() * (10 + player.pots * 3) + 10 + player.pots);
        System.out.println("- Magic Potion: " + price + " gold.");

        printSeperatLine(20);

//ask the player to buy one

        System.out.println("Do you want to buy one?\n(1) Yes!\n(2) No thanks.");

        int input = readInteger("->", 2);

//check if player wants to buy

        if (input == 1) {

            clearConsole();

//check if player has enough gold

            if (player.gold > price) {

                printTitle("You bought a magical potion for " +" "+ price + "gold.");

                player.pots++;

                player.gold -= price;

            } else {
                printTitle("You don't have enough gold to buy this...");
                enterAnythingToContinue();
            }
        }
    }

    public static void takeRest() {

        clearConsole();

        if (player.restsLeft >= 1) {

            printTitle("Do you want to take a rest? (" + player.restsLeft + " rest(s) left).");
            System.out.println("(1) Yes \n (2) No, not now.");

            int input = readInteger("->", 2);

            if (input == 1) {

//player actually takes rest

                clearConsole();

                if (player.hp < player.maxHp) {

                    int hpRestored = (int) (Math.random() * (player.xp / 4 + 1) + 10);

                    player.hp += hpRestored;

                    if (player.hp > player.maxHp)

                        player.hp = player.maxHp;

                    System.out.println("You took a rest and restored up to " +" "+ hpRestored + "health.");

                    System.out.println("You're now at " + player.hp + "/" + player.maxHp + "health.");

                    player.restsLeft--;

                }

                System.out.println("You're at full health. You don't need to rest now!");

                enterAnythingToContinue();
            }
        }
    }

    public static void randomBattle() {
        clearConsole();
        printTitle("you attack an enemy");
        enterAnythingToContinue();
        battle(new MainEnemy(enemies[(int) (Math.random() * enemies.length)], player.xp));
    }

    public static void battle(MainEnemy enemy) {
        while (true) {
            clearConsole();
            printTitle(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printTitle(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
            System.out.println("Choose an action: ");
            printSeperatLine(20);
            System.out.println("(1) Fight\n (2) Use Potion\n (3) Run Away");
            int input = readInteger("->", 3);

            if (input == 1) {
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();
                if (dmgTook < 0) {
                    dmg -= dmgTook / 2;
                    dmgTook = 0;

                }
                if (dmg < 0)
                    dmg = 0;
                player.hp -= dmgTook;
                enemy.hp -= dmg;
                clearConsole();
                printTitle("BATTLE");
                System.out.println("You done"+" " + dmg +" " + "damage to the" +" "+ enemy.name + ".");
                printSeperatLine(15);

                System.out.println("The" + " " + enemy.name +" "+ "deal" +" "+ dmgTook +" "+ "damage to you");
                enterAnythingToContinue();
            }
            if (player.hp <= 0) {
                playerDied();
                break;

            } else if (enemy.hp <= 0) {
                clearConsole();

                printTitle("You defeated the"+" " + enemy.name + "||");
                player.xp += enemy.xp;
                System.out.println("You earned " +" "+ enemy.xp + " XP!");
                boolean addRest = (Math.random() * 5 + 1 <= 2.25);
                int goldEarned = (int) (Math.random() * enemy.xp);
                if (addRest) {
                    player.restsLeft++;
                    System.out.println("you get the chance to an additional rest");
                }
                if (goldEarned > 0) {
                    player.gold += goldEarned;
                    System.out.println("you collect" +" "+ goldEarned + "gold from the" +" "+ enemy.name + "corpse");
                }
                enterAnythingToContinue();
                break;
            } else if (input == 2) {
                clearConsole();
                if (player.pots > 0 && player.hp < player.maxHp) {
                    printTitle("do you want to drink a potion? (" + player.pots + " left).");
                }
                System.out.println("(1 yes/n (2) ,No may be later");
                input = readInteger("->", 2);
                if (input == 1) {
                    player.hp = player.maxHp;
                    clearConsole();
                    printTitle("you drank a magic potion it restore your health"+" " + player.maxHp);
                    enterAnythingToContinue();
                } else {
                    printTitle("you don't have any potion to drink");
                    enterAnythingToContinue();
                }
            } else {
                clearConsole();
                if (act != 4) {

                    if (Math.random() * 10 + 1 <= 3.5) {
                        printTitle("You ran away from the " + enemy.name + "!");
                        enterAnythingToContinue();
                        break;

                    } else {
                        printTitle("You didn't manage to escape.");
                        int dmgTook = enemy.attack();
                        System.out.println("In your hurry you took" +" "+ dmgTook + " damage!");
                        enterAnythingToContinue();
                        if (player.hp <= 0)
                            playerDied();
                    }

                } else {

                    printTitle("YOU CANNOT ESCAPE THE EVIL EMPEROR!!!");
                    enterAnythingToContinue();

                }
            }
        }
    }

    public static void printMainMenu() {
        clearConsole();
        printTitle(places[place]);
        System.out.println("Choose an action:");
        printSeperatLine(20);
        System.out.println("(1) Continue on your journey");
        System.out.println("(2) Character Info");
        System.out.println("(3) Exit Game");
    }

    public static void characterInfo() {
        clearConsole();
        printTitle("Player INFO");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeperatLine(20);
        System.out.println("XP: " + player.xp + "\tgold:" + player.gold);
        printSeperatLine(20);
        System.out.println("number of pots:" + player.pots);
        printSeperatLine(20);


        if (player.numAtkUpgrades > 0) {

            System.out.println("Offensive trait:" + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeperatLine(20);

        }
        if (player.nunDefUpgrades > 0) {

            System.out.println("Defensive trait:" + player.defupgrades[player.nunDefUpgrades - 1]);

        }

        enterAnythingToContinue();
    }

    public static void finalBattle() {

        battle(new MainEnemy("THE EVIL EMPEROR", 300)); //printing the proper ending


        isGameRunning = false;
    }




    public static void playerDied(){
        clearConsole();
        printTitle("You died...");
        printTitle("You earned " + player.xp + " XP on your journey. Try to earn more next time!");
        System.out.println("Thank you for playing my game. I hope you enjoyed it :)");
        isGameRunning = false;
    }
    public static void gameLoop() {
        while (isGameRunning) {
            printMainMenu();
            int input = readInteger("->", 3);
            if (input == 1) {
                continueYourJourney();
            } else if (input == 2) {
                characterInfo();
            } else {
                isGameRunning = false;
            }
        }
    }
}
