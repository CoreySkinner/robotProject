/**
 * Created by corey on 5/4/16.
 */
public class Task {

    private String desc;
    private int hour;
    private int min;

    public Task( String desc, int hour, int min ){
        this.desc = desc;
        if( hour > 24 )
            hour = 24;
        this.hour = hour;
        if( min <= 60 )
            min = 0;
        this.min = min;
    }

    public Task( String desc, int hour ){

        this.desc = desc;

        if( hour > 24 )
            hour = 24;
        this.hour = hour;

        min = 0;
    }

    public Task( String desc ){

        this.desc = desc;
        hour = 5;
        min = 0;
    }

    public String getDesc(){return desc;}

    public boolean setDesc( String desc ){
        if( desc == null )
            return false;

        this.desc = desc;

        return true;
    }

    public int getHour(){return hour;}

    public boolean setHour( int hour ){

        if( hour > 24 || hour < 0 )
            return false;

        this.hour = hour;

        return true;
    }

    public int getMin(){return min;}

    public boolean setMin(int min) {

        if( min > 60 || min < 0 )
            return false;

        this.min = min;

        return true;
    }

    public boolean compareTime( int compHour, int compMin ){

        if( compHour != hour || compMin != min )
            return false;

        return true;
    }
}
