import java.sql.SQLOutput;

public class GameStory {
    public static void printIntroStory(){
        MainLogic.clearConsole();
       MainLogic.printSeperatLine (30);
        System.out.println("GAME STORY");
        MainLogic.printSeperatLine(30);
        System.out.println("You are the last man standing after your village got raided by the devilment of the evil war.");
        System.out.println("Every single one of your friends, family and neighbours got murdered. You are standing in burning ruins of this once ");
        System.out.println("All you want now is revenge, so you begin planning your journey to defeat the evil emperor and free the lands!");
       MainLogic.enterAnythingToContinue();
}
    public static void printFirstActionStory() {
        MainLogic.clearConsole();
        MainLogic.printSeperatLine(30);
        System.out.println("First action GAME STORY");
        MainLogic.printSeperatLine(30);
        System.out.println("As you begin your journey you start travelling trough the nearby woods to reach the everlasting mountains.");
        System.out.println("The everlasting contains are a very dangerous place. It says nobody came back alive from there.");
        System.out.println("After a long day of walking through the woods, you finally reach the everlasting mountains.");
        System.out.println("You don't care about the things you've heard about this dangerous place and start your journey to defeat the evil war");
        MainLogic.enterAnythingToContinue();
    }
    public static void printFirstActionOutputStory() {
        MainLogic.clearConsole();
        MainLogic.printSeperatLine(30);
        System.out.println("First action output GAME STORY");
        MainLogic.printSeperatLine(30);
        System.out.println("You did it you cross the dangerous mountain and still alive||");
        MainLogic.enterAnythingToContinue();

    }

    public static void printSecondActionStory() {
        MainLogic.clearConsole();
        MainLogic.printSeperatLine(30);
        System.out.println("Second Action Game Story");
        MainLogic.printSeperatLine(30);
        System.out.println("Your just few km away from reaching your final destination i.e the evil war");
        System.out.println("You know exactly where is evil war and to reach there you have to cross haunted landlines first||");
        MainLogic.enterAnythingToContinue();

    }

    public static void printSecondActionOutputStory() {
        MainLogic.clearConsole();
        MainLogic.printSeperatLine(30);
        System.out.println("Second Action Output GAME STORY");
        MainLogic.printSeperatLine(30);
        System.out.println("You managed to cross these hunted landlines and you are still alive.");
        System.out.println("After all you have seen you feel empowered to learn another trait");
        MainLogic.enterAnythingToContinue();

    }

    public static void printThirdActionStory() {
        MainLogic.clearConsole();
        MainLogic.printSeperatLine(30);
        System.out.println("Third Action Game Story");
        MainLogic.printSeperatLine(30);
        System.out.println("You see huge black castle in-front of you");
        System.out.println("You stand in-front of the gate and you know there is no going back ");
        System.out.println("All you can do now is to fight for your life||");
        MainLogic.enterAnythingToContinue();

    }
    public static void printThirdActionOutputStory() {
        MainLogic.clearConsole();
        MainLogic.printSeperatLine(30);
        System.out.println("Second Action output Game Story");
        MainLogic.printSeperatLine(30);
        System.out.println("You came so far you defeated all the evil war enemies");
        System.out.println("You get the chance to learn a last trait before entering the throne room");
        MainLogic.enterAnythingToContinue();

    }

    public static void printEndStory() {
        MainLogic.clearConsole();
        MainLogic.printSeperatLine(30);
        System.out.println("End Game Story");
        MainLogic.printSeperatLine(30);
        System.out.println("You enter the throne room of the Evil War.");
        System.out.println("He takes out the mightiest weapon known to man.");
        System.out.println("All you can do is to fight for your life and pray to come out as the winner...");
        MainLogic.enterAnythingToContinue();

    }
    public static void printEnd(MainPlayer player){
        MainLogic.clearConsole();
        MainLogic.printSeperatLine(30);
        System.out.println("Congratulations,"+ player.name+" You defeated the Evil Emperor and saved the world");
        MainLogic.printSeperatLine(30);
        System.out.println("I hope you enjoyed it!");
    }
}
