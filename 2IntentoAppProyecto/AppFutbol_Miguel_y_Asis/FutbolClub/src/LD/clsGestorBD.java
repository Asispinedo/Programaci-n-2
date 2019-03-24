package LD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * En esta clase se establece el acceso base de de datos de la que
 *  posteriormente van a hacer uso todas las clases que hay en la lógica de datos
 */
public class clsGestorBD{
     
    private static clsGestorBD instance = null;
 
    private Connection connection = null;
 
    private void checkConnected()
    {
            if (connection == null)
                    throw new IllegalStateException(
                                    "La conexion a la BD no ha sido creada todavia.");
    }
 
    private clsGestorBD()
    {
    }
 
    public static clsGestorBD getInstance()
    {
        if (instance == null)
        {
                instance = new clsGestorBD();
        }
        return instance;
    }
 
    public static void releaseInstance()
    {
        instance = null;
    }
 
    public void connect() throws SQLException
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } 
        catch (ClassNotFoundException e) {
 
            e.printStackTrace();
        }
         
        //useSSL = true para que la conexion sea cifrada
        //cambiar ui1_artupa por el nombre de nuestra base de datos
        String sURL = "jdbc:mysql://localhost:3306/sqlDeEquipo?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
         
        connection = java.sql.DriverManager.getConnection( sURL , "root", "root");
        //System.out.println("funciona.");
    }
 
    public void disconnect() throws SQLException
    {
        checkConnected();
        connection.close();
    }
 
    public Statement createStatement() throws SQLException
    {
        checkConnected();
        return connection.createStatement();
    }   
     
    public Statement createStatement(int resultSetType , int resultSetConcurrency ) throws SQLException
    {
        checkConnected();
        return connection.createStatement(resultSetType, resultSetConcurrency );
    }   
}