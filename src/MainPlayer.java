public class MainPlayer extends MainCharacter {
    public int numAtkUpgrades, nunDefUpgrades;
    int gold,restsLeft,pots;
    public String[] atkUpgrades = {"Strength", "Power", "Might", "Godlike Strength"};
    public String[] defupgrades = {"Heavy Bones", "Stoneskin", "Scale Armor", "Holy Aura"};

    public MainPlayer(String name) {
        super(name, 100, 0);
        this.numAtkUpgrades = 0;
        this.nunDefUpgrades = 0;
        this.gold=5;
        this.restsLeft=1;
        this.pots=0;
        chooseTrait();
    }

    @Override
    public int attack() {
        return (int) (Math.random()*(xp/4+ numAtkUpgrades *3+3)+ xp/10+ numAtkUpgrades *2+ nunDefUpgrades+ 1);
    }

    public int defend() {
        return (int) (Math.random() * (xp/4 + nunDefUpgrades*3 + 3) + xp/18 + nunDefUpgrades *2+ numAtkUpgrades + 1);
    }

    public void chooseTrait() {
        MainLogic.clearConsole();
        MainLogic.printTitle("lets choose a trait");
        System.out.println("(1)" + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2)" + defupgrades[nunDefUpgrades]);
        int input = MainLogic.readInteger("->", 2);
        MainLogic.clearConsole();
        if (input == 1) {

            MainLogic.printTitle("You chose" + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;

        } else {

            MainLogic.printTitle("You chose" + defupgrades[nunDefUpgrades] + "!");
            nunDefUpgrades++;

            MainLogic.enterAnythingToContinue();
        }
    }
}
