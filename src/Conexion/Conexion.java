package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author VA
 */
public class Conexion {

    private static java.sql.Connection conx = null;
    public Connection con;

    public Conexion() {
    }

    public Conexion(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void conectar() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/inventario?user=root&password=");
        } catch (SQLException e) {
            throw e;
        }
    }
    public static java.sql.Connection getConnection() {
        if (conx != null) {
            return conx;
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3307/inventario?user=root&password=";
                String user = "root";
                String password = "";

                conx = DriverManager.getConnection(url, user, password);
                System.out.println("Conectado Correctamente");

            } catch (ClassNotFoundException conn) {
                System.out.println("Driver");
                conn.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Excepcion");
                System.out.println(e);
            }
            return conx;
        }
    }

    public void desconectar() throws Exception {
        try {
            if (con != null) {
                if (con.isClosed() == false) {
                    con.close();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public PreparedStatement prepareStatement(String update_clientes_SET_nom_clteape_clte_ciud) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
