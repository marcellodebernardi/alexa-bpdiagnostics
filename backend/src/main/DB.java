package main;

import java.sql.*;

public class DB
{

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public DB()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://alexa.ccihfqr4zy2e.us-east-1.rds.amazonaws.com/bp", "alexa", "PikaBoo123");
            st = con.createStatement();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        DB connect = new DB();
        connect.addCheckUP();
    }

    public void addCheckUP()
    {
        try
        {
            String query = "INSERT INTO `bp`.`checkups` (`customer`, `DOB`, `car_odometer`, `car_battery`, `car_modelYear`, `car_modelName`, `car_makeName`, `engine_OSH`, `engine_misfire`, `engine_fuelSystem`, `engine_catalyst`, `issues`, `appointment`)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prep = con.prepareStatement(query);
            prep.setString(1, "Marcello");
            prep.setString(2, "19/12/1997");
            prep.setString(3, "test");
            prep.setString(4, "test");
            prep.setString(5, "test");
            prep.setString(6, "test");
            prep.setString(7, "test");
            prep.setString(8, "test");
            prep.setString(9, "test");
            prep.setString(10, "test");
            prep.setString(11, "test");
            prep.setString(12, "test");
            prep.setString(13, "test");
            prep.execute();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
