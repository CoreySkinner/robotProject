import java.util.Scanner;

/**
 * Created by corey on 5/4/16.
 */
public class Interaction {

    private Task[] tasks;
    private Scanner in;

    public Interaction( int x){
        tasks = new Task[x * 2];
        in = new Scanner( System.in );
        addMultipleTasks(x);
    }

    public void addMultipleTasks( int count ){

        while( count > 0 ){
            count--;
            addTask();
        }
    }

    public void addTask(){

        String desc;
        int count = 0;
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

        while( count < tasks.length && tasks[count] != null )
            count++;

        tasks[count] = t;
    }

    public void act(){

        String ans = null;
        while( !"finished".equals(ans = in.nextLine())){

            System.out.println("Enter a command. Enter help to get the list of commands");
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
                default:
                    System.out.println("invalid command");
            }
        }
    }

    public void printCommands(){
        System.out.println("Your commands are:\nhelp\nadd task\n" +
                "list tasks\nget time\n");
    }

    public void printTasks(){

        int count = 0;

        while( count < tasks.length && tasks[count] != null ) {
            System.out.println(tasks[count].getDesc());
            count++;
        }
    }

    public static void main( String[] args ){
        Interaction interaction = new Interaction(3);
        interaction.act();
        System.exit(0);
    }
}
