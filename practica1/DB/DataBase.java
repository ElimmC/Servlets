package mx.upiicsa.web.servlets.practica1.DB;

import java.sql.DriverManager;
import java.sql.Connection;

public class DataBase {
    Connection connection;
    protected Connection connectDatabase() {

        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            connection = null;
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/discos",
                    "pweb", "pweb");

            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");


        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
        return null;
    }

    protected void desconectar() {
        try {
            connection.close();
        }catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }

    }
}
