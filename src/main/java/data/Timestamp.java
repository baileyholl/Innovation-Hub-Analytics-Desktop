package data;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Timestamp {

    private String start;
    private String end;
    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("MM-dd-yyyy hh:mm a");

    public Timestamp(String start, String end){
        this.start = start;
        this.end = end;
    }

    public Timestamp(String start){
        this.start = start;
        this.end = "";
    }

    public Timestamp(){
        start = "";
        end = "";
    }

    public static Timestamp Now(){
        return new Timestamp(getCurrentTime());
    }

    public static String getCurrentTime(){
        return dateTimeFormatter.print(DateTime.now());
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * @return Returns the duration between the start and end times.
     */
    public Duration getTimeLength(){
        if(end == null || start == null || start.isEmpty() || end.isEmpty()){
            return new Duration(0,0);
        }
        return new Duration(dateTimeFormatter.parseDateTime(start), dateTimeFormatter.parseDateTime(end));
    }
}
