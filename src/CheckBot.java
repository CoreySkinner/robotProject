import java.util.HashSet;

/**
 * Created by corey on 5/7/16.
 */
public class CheckBot implements Runnable {

    private HashSet<Task> tasks;

    public CheckBot( HashSet tasks ){
        this.tasks = tasks;
    }

    public boolean setTasks( HashSet t ){

        if( t == null )
            return false;

        tasks = t;
        return true;
    }

    public void inComplete(){


        for( Task t : tasks ){
            if( !t.isComplete() ){
                System.out.printf("Please remember to %s by %s\n",
                        t.getDesc(), t.timeToString() );
            }
        }
    }

    @Override
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
