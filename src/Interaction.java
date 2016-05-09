import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by corey on 5/4/16.
 */
public class Interaction {

    private static HashSet<Task> tasks;
    private Scanner in;
    private CheckBot checkBot;
    private AskBot askBot;

    public Interaction(){
        tasks = new HashSet<>();
        in = new Scanner( System.in );
        in.useDelimiter("\\n|\\r\\n?");
        checkBot = new CheckBot(tasks);
        askBot = new AskBot(tasks);
    }

    public void act(){

        checkBot.setTasks(tasks);
        Thread ask = new Thread(askBot);
        ask.start();
        Thread checker = new Thread(checkBot);
        checker.start();
    }

    public static void exit(){

        System.exit(0);
    }

    public static void main( String[] args ){
        Interaction interaction = new Interaction();
        interaction.act();
    }
}
