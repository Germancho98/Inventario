
package Dao;
import Conexion.Conexion;
import Modelo.Inventario;
import Vista.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Germancho
 */
public class DaoInventario extends Conexion{
    
    public void GuardarUsuario(Inventario in) throws Exception{
        ResultSet rs;
        try {
            this.conectar();
            String sql ="INSERT INTO inventario(idInventario,Numero,Marca,Procesador,Estado,Almacenamiento,MemoriaRAM,MAC,Accesorios) Values (?,?,?,?,?,?,?,?,?)"; 
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, in.getIdinventario());
            pre.setInt(2, in.getNumero());
            pre.setString(3, in.getMarca());
            pre.setString(4, in.getProcesador());
            pre.setString(5, in.getEstado());
            pre.setString(6, in.getAlmacenamiento());
            pre.setString(7, in.getRam());
            pre.setString(8, in.getMac());
            pre.setString(9, in.getAccesorios());
            pre.execute();
            
            JOptionPane.showMessageDialog(null, "Equipo agregado al inventario correctamente, ahora registre el usuario");
            
        } catch (SQLException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            this.desconectar();
        }
    }
    public ArrayList ConsultarCombo() {
        ArrayList invList=new ArrayList<>();
        Connection connection=null;
        Conexion co=new Conexion();
        PreparedStatement statement=null;
        ResultSet result=null;
        
        Inventario in;
        connection=co.getCon();
        String consulta="SELECT * FROM inventario";
        
        try {
            if (connection != null) {
                statement = connection.prepareStatement(consulta);
                result = statement.executeQuery();

                while (result.next() == true) {
                    in = new Inventario();
                    in.setIdinventario(result.getInt("idInventario"));
                    in.setNumero(result.getInt("Numero"));
                    in.setMarca(result.getString("Marca"));
                    in.setProcesador(result.getString("Procesador"));
                    in.setEstado(result.getString("Estado"));
                    in.setAlmacenamiento(result.getString("Almacenamiento"));
                    in.setRam(result.getString("MemoriaRAM"));
                    in.setMac(result.getString("MAC"));
                    in.setAccesorios(result.getString("Accesorios"));
                    invList.add(in);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return invList;
    }
    public void consultar_paises(JComboBox cbox_paises) {
        java.sql.Connection conectar = null;
        PreparedStatement pst = null;
        ResultSet result = null;
        PreparedStatement statement = null;
        Connection connection = null;
        Conexion co = new Conexion();
        connection = co.getCon();
        String sql = "SELECT * FROM inventario ORDER BY idInventario DESC LIMIT 1";
        //Establecemos bloque try-catch-finally
        try {
            //Establecemos conexión con la BD 
            conectar = co.getConnection();
            //Preparamos la consulta SQL
            pst = conectar.prepareStatement(sql);
            //Ejecutamos la consulta
            result = pst.executeQuery();
            while (result.next()) {
                cbox_paises.addItem(result.getInt("idInventario"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            if (conectar != null) {
                try {
                    conectar.close();
                    result.close();
                    conectar = null;
                    result = null;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }
}
