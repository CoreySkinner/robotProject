import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by corey on 5/4/16.
 */
public class Interaction {

    private static HashSet<Task> tasks;
    private Scanner in;
    private CheckBot checkBot;

    public Interaction(){
        tasks = new HashSet<>();
        in = new Scanner( System.in );
        in.useDelimiter("\\n|\\r\\n?");
        checkBot = new CheckBot(tasks);
        addMultipleTasks();
    }

    public void addMultipleTasks( ){

        String ans = "yes";

        do{
            addTask();
            System.out.println("Is there another task you need reminder of?");
        }
        while( "yes".equals(ans = in.nextLine().toLowerCase()) );
    }

    public void addTask(){

        String desc;
        Task t = null;

        System.out.println("What is the description of the task you need a reminder of?");
        desc = in.nextLine();

        System.out.println("Is there a specific time this needs to be done by?(yes/no)");

        if( in.nextLine().equals("yes")){
            int time = in.nextInt();
            t = new Task(desc, time );
        }
        else
            t = new Task(desc);

        tasks.add( t );
    }

    public void act(){

        String ans = null;
        checkBot.setTasks(tasks);
        Thread checker = new Thread(checkBot);
        checker.start();

        while( !"finished".equals(ans)){

            System.out.println("Enter a command. Enter help to get the list of commands");
            ans = in.nextLine().toLowerCase();

            switch (ans){
                case "help":
                    printCommands();
                    break;
                case "add task":
                    addTask();
                    checkBot.setTasks(tasks);
                    break;
                case "list tasks":
                    printTasks();
                    break;
                default:
                    System.out.println("invalid command");
            }
        }
    }

    public void printCommands(){
        System.out.println("Your commands are:\nhelp\nadd task\n" +
                "list tasks\nget time\nfinished\n");
    }

    public void printTasks(){

        for( Task t : tasks ){
            System.out.println(t.getDesc());
        }
    }

    public static HashSet getTasks(){
        return tasks;
    }

    public static void main( String[] args ){
        Interaction interaction = new Interaction();
        interaction.act();
        System.exit(0);
    }
}
