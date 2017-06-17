package main;

import java.util.*;

/**
 * Created by joantsomw on 6/17/17.
 */
public class Appointment {

    private String time;
    private Date date;
    private String name;

    public Appointment(String time, Date date, String name) {

        this.time = time;
        this.date = date;
        this.name = name;

    }

    public String getTime() {
        return time;
    }

    public Date getDate() {
        return date;
    }

}
