/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.Serializable;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Lorenzo Erba, 748702
 *
 * Lorenzo Erba, 748702,Ferialdo Elezi 749721,Alessandro Zancanella
 * 751494,Matteo Cacciarino 748231, sede CO
 *
 * Classe rappresentante la connessione al database
 */
public class Database implements Serializable {

    private final static String protocol = "jdbc:postgresql" + "://";
    private final static String host = "emotionalsongs.c9bcs8galrpt.eu-north-1.rds.amazonaws.com:5432" + "/";
    private final static String resource = "EmotionalSongs";

    private final static String url = protocol + host + resource;
    private static String user;
    private static String pass;

    private static Database database;
    private static Connection connection;
    private static Statement statement;

    // Questo costruttore, grazie al metodo getInstance, potrà
    // essere invocato una volta sola.
    private Database(String username, String password) throws SQLException {

        user = username;
        pass = password;
        connection = DriverManager.getConnection(url, user, pass);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    // Sfrutto il pattern Singleton per assicurarmi di gestire la 
    // comunicazione con il db in modo centralizzato.
    public static Database getInstance(String user, String pass) throws SQLException {

        if (database == null) {
            database = new Database(user, pass);
        }

        return database;
    }

    //executeQuery per eseguire una query ed executeUpdate per il DDL
    public ResultSet submitQuery(String query) throws SQLException {

        return statement.executeQuery(query);
    }

    public int submitQueryUpdate(String query) throws SQLException {
        return statement.executeUpdate(query);
    }

    //metodo per ristabilire la connessione al db
    public static Connection getConnection() throws SQLException {

        if (connection == null) {
            connection = DriverManager.getConnection(url, user, pass);
        }

        return connection;
    }

    //meotod per chiudere la connessione al db
    public static void closeConnection() throws SQLException {

        connection.close();
        connection = null;
    }

    //metodo per creare un nuovo statement
    public static Statement getStatement() throws SQLException {

        if (statement == null) {

            Connection connection = getConnection();
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        }

        return statement;
    }

    //metodo per chiudere lo statement
    public static void closeStatement() throws SQLException {

        statement.close();
        statement = null;
    }
}
