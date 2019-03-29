package apis;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by joantsomw on 6/17/17.
 */
public class ServiceCentreDatabase {

    private static final int MAX_NUMBER_PRE_SLOT = 3;

    private List<Appointment> appointments= new LinkedList<>();

    public ServiceCentreDatabase() {}

    public boolean avaliable(String time, Date date){
        int numberCurrentInSlot = 0;
        for (Appointment a: appointments) {
            if (a.getTime().equals(time) && a.getDate().equals(date)) {
                numberCurrentInSlot++;
            }
        }
        return numberCurrentInSlot < MAX_NUMBER_PRE_SLOT;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
}
