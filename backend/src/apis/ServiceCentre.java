package apis;

/**
 * Created by joantsomw on 6/17/17.
 */
public class ServiceCentre {

    private String postalCode;
    private ServiceCentreDatabase database;

    public ServiceCentre(String postalCode, ServiceCentreDatabase database) {
        this.postalCode = postalCode;
        this.database = database;
    }

    public ServiceCentreDatabase getDatabase() {
        return database;
    }
}
