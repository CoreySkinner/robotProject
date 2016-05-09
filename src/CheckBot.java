import java.util.HashSet;

/**
 * Created by corey on 5/7/16.
 */
public class CheckBot implements Runnable {

    private HashSet<Task> tasks;

    /**
     * Constructor for CheckBot class
     * @param tasks the hashset of tasks the checkbot looks at
     */
    public CheckBot( HashSet tasks ){
        this.tasks = tasks;
    }

    /**
     * sets the tasks hashset
     * @param t a hashset of Task objects
     * @return true if parameter was not null
     */
    public boolean setTasks( HashSet t ){

        if( t == null )
            return false;

        tasks = t;
        return true;
    }

    /**
     * prints a list of incomplete tasks with a time to complete them by
     */
    public void inComplete(){


        for( Task t : tasks ){
            if( !t.isComplete() ){
                System.out.printf("Please remember to %s by %s\n",
                        t.getDesc(), t.timeToString() );
            }
        }
    }

    @Override
    /**
     * runs the checkBot thread
     */
    public void run() {
        try{
            while(true) {
                inComplete();
                Thread.sleep(60000);
                System.out.println("\nEnter a command, or help for a list of commands\n");
            }
        }catch (Exception e){}
    }
}
