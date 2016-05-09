import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by corey on 5/8/16.
 */
public class AskBot implements Runnable{

    private HashSet<Task> tasks;
    private Scanner in;

    /**
     * Contructor for AskBot class
     * @param tasks a list of the current tasks
     */
    public AskBot( HashSet tasks ){

        this.tasks = tasks;
        in = new Scanner(System.in);
        in.useDelimiter("\\n|\\r\\n?");
    }

    /**
     * sets the task
     * @param t the updated task hashset
     * @return boolean true if paramer was not null
     */
    public boolean setTasks( HashSet t ){

        if( t == null )
            return false;

        tasks = t;
        return true;
    }

    /**
     * promts user to add multiple tasks
     */
    public void addMultipleTasks( ){

        String ans = "yes";

        do{
            addTask();
            System.out.println("Is there another task you need reminder of?");
        }
        while( "yes".equals(ans = in.nextLine().toLowerCase()) );
    }

    /**
     * prompts the user to enter information for a new task
     */
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

    /**
     * Continuosly prompts user for commands in case they need or want to interact with it
     */
    public void run(){

        addMultipleTasks();

        String ans = null;
        while( !"finished".equals(ans)){

            System.out.println("Enter a command. Enter help to get the list of commands");
            ans = in.nextLine().toLowerCase();

            switch (ans){
                case "help":
                    printCommands();
                    break;
                case "add task":
                    addTask();
                    break;
                case "list tasks":
                    printTasks();
                    break;
                case "complete":
                    completeTask();
                    break;
                case "finished":
                    Interaction.exit();
                    break;
                default:
                    System.out.println("invalid command");
            }
        }
    }

    /**
     * locates a task and sets its status to complete
     */
    public void completeTask(){

        String desc;
        System.out.println("which task is complete");
        desc = in.nextLine();

        for( Task t: tasks){
            if( t.getDesc().equals(desc) )
                t.setComplete(true);
        }
    }

    /**
     * gives the user a list of all commands
     */
    public void printCommands(){
        System.out.println("Your commands are:\nhelp\nadd task\n" +
                "list tasks\nget time\nfinished\n");
    }

    /**
     * prints a list of the tasks in a readable format
     */
    public void printTasks(){

        for( Task t : tasks ){
            System.out.println(t.getDesc());
        }
    }
}
