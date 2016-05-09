/**
 * Created by corey on 5/4/16.
 */
public class Task {

    private String desc;
    private int hour;
    private int min;
    private boolean complete;

    /**
     * Constructor for Task class
     * @param desc as description of the task
     * @param hour the hour ( 1-24 ) that the task needs to be complete by
     * @param min the minute in the hour the task needs to be done by
     */
    public Task( String desc, int hour, int min ){
        this.desc = desc;
        if( hour > 24 )
            hour = 24;
        this.hour = hour;
        if( min <= 60 )
            min = 0;
        this.min = min;
        complete = false;
    }

    /**
     * Constructor for Task class
     * @param desc as description of the task
     * @param hour the hour ( 1-24 ) that the task needs to be complete by
     */
    public Task( String desc, int hour ){

        this.desc = desc;

        if( hour > 24 )
            hour = 24;
        this.hour = hour;

        min = 0;
        complete = false;
    }

    /**
     * Constructor for Task class
     * @param desc as description of the task
     */
    public Task( String desc ){

        this.desc = desc;
        hour = 5;
        min = 0;
        complete = false;
    }

    /**
     * gets the description of the task
     * @return String, the desc variable
     */
    public String getDesc(){return desc;}

    /**
     * sets the desctipton
     * @param desc the new desc of the class
     * @return boolean true if the new desc is acceptable
     */
    public boolean setDesc( String desc ){
        if( desc == null )
            return false;

        this.desc = desc;

        return true;
    }

    /**
     * gets the hour of the task
     * @return int hour
     */
    public int getHour(){return hour;}

    /**
     * sets the hour for the task
     * @param hour new time for the task
     * @return boolean true if the new hour is between 1 and 24
     */
    public boolean setHour( int hour ){

        if( hour > 24 || hour < 0 )
            return false;

        this.hour = hour;

        return true;
    }

    /**
     * gets the min time of the task
     * @return int min
     */
    public int getMin(){return min;}

    /**
     * sets the minute for the task
     * @param min the new minute time of the task
     * @return boolean true if the min is between 0 and 60
     */
    public boolean setMin(int min) {

        if( min > 60 || min < 0 )
            return false;

        this.min = min;

        return true;
    }

    /**
     * converts the time ( hour and minute ) to an easy to read string
     * @return String the time
     */
    public String timeToString(){

        if( hour <= 12)
            return hour + ":00 A.M.";
        else {
            return (hour - 12 ) + ":00 P.M.";
        }
    }

    /**
     * compares the time to the input time
     * @param compHour the hour to be compared
     * @param compMin the min to be compared
     * @return boolean true if both parameters match
     */
    public boolean compareTime( int compHour, int compMin ){

        if( compHour != hour || compMin != min )
            return false;

        return true;
    }

    /**
     * sets the complete status
     * @param is the new status of complete
     */
    public void setComplete( boolean is){
        complete = is;
    }

    /**
     * checks if the task is complete
     * @return boolean complete status of this task
     */
    public boolean isComplete() {
        return complete;
    }
}
