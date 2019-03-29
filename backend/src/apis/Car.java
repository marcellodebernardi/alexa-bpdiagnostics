package apis;

/**
 * Created by Admin on 17/06/2017.
 */
public class Car {
    private String vin;
    private String name;
    private String engineModel;
    private String engineCondition;
    private String brakeModel;
    private String brakeCondition;
    private int tirePressure;

    public Car(boolean plugged, String vin, String name, String engineModel, String engineCondition, String brakeModel, String brakeCondition, int tirePressure) {
        this.vin = vin;
        this.name = name;
        this.engineModel = engineModel;
        this.engineCondition = engineCondition;
        this.brakeModel = brakeModel;
        this.brakeCondition = brakeCondition;
        this.tirePressure = tirePressure;
    }

    public String getVin() {
        return vin;
    }

    public String getName() {
        return name;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public String getEngineCondition() {
        return engineCondition;
    }

    public String getBrakeModel() {
        return brakeModel;
    }

    public String getBrakeCondition() {
        return brakeCondition;
    }

    public int getTirePressure() {
        return tirePressure;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public void setEngineCondition(String engineCondition) {
        this.engineCondition = engineCondition;
    }

    public void setBrakeModel(String brakeModel) {
        this.brakeModel = brakeModel;
    }

    public void setBrakeCondition(String brakeCondition) {
        this.brakeCondition = brakeCondition;
    }

    public void setTirePressure(int tirePressure) {
        this.tirePressure = tirePressure;
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + '\'' +
                ", name='" + name + '\'' +
                ", engineModel='" + engineModel + '\'' +
                ", engineCondition='" + engineCondition + '\'' +
                ", brakeModel='" + brakeModel + '\'' +
                ", brakeCondition='" + brakeCondition + '\'' +
                ", tirePressure=" + tirePressure +
                '}';
    }
}
