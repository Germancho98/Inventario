package Dao;

import Vista.FrmAdministrador;
import Vista.FrmInvitado;
import Vista.FrmLogin;
import Conexion.Conexion;
import Modelo.Usuario;
import Modelo.Inventario;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author VA
 */
public class DaoUsuario extends Conexion {
    static ResultSet rs;
    static PreparedStatement pre;
    FrmInvitado inv = new FrmInvitado();

    public void acceder(Usuario us) throws Exception {

        ResultSet rs;
        try {

            this.conectar();
            String cap = "";
            String nom = "";
            String ape ="";
            String est = ""; 
            String cor ="";
            String pass="";
            String num="";
            String Marca="";
            String Procesador="";
            String Estado="";
            String Alma="";
            String Ram=("");
            String Mac=("");
            String Acc=("");
            String cod=("");
            String sql = "select * from usuario u inner join inventario i on u.Inventario_idInventario = i.idInventario where u.Correo=? && u.Contraseña=?";
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setString(1, us.getCorreouser());
            pre.setString(2, us.getPassuser());
            rs = pre.executeQuery();
            while (rs.next()) {
                cap = rs.getString("Tipo");
                nom = rs.getString("Nombre");
                ape = rs.getString("Apellido");
                est = rs.getString("Estado");
                cor = rs.getString("Correo");
                pass = rs.getString("Contraseña");
                num = rs.getString("Numero");
                Marca = rs.getString("Marca");
                Procesador = rs.getString("Procesador");
                Estado = rs.getString("Estado");
                Alma = rs.getString("Almacenamiento");
                Ram = rs.getString("MemoriaRAM");
                Mac = rs.getString("MAC");
                Acc = rs.getString("Accesorios");
                cod = rs.getString("idUsuario");
            }
            
            if (cap.equals("Administrador") && est.equals("Activo")) {

                JOptionPane.showMessageDialog(null, "Bienvenido Administrador");
                FrmAdministrador ingreso = new FrmAdministrador();
                ingreso.setVisible(true);
                ingreso.pack();
                ingreso.getLabel().setText("Bienvenido " + nom +" "+ape);
                ingreso.getLabel1().setText("Numero de equipo asignado " + num);
                ingreso.getLabel2().setText("Marca del equipo "+ Marca);
                ingreso.getLabel3().setText("Procesador "+Procesador);
                ingreso.getLabel4().setText("Estado equipo "+Estado);
                ingreso.getLabel5().setText("Capacidad de almacenamiento "+Alma);
                ingreso.getLabel6().setText("Memoria ram "+Ram);
                ingreso.getLabel7().setText("Dirección mac "+ Mac);
                ingreso.getLabel8().setText("Accesorios asignados "+Acc);
                ingreso.getLabel9().setText(cor);
                ingreso.getLabel10().setText(pass);
                ingreso.gatLabel11().setText(cod);
            }else if(cap.equals("Empleado") && est.equals("Activo")){
                JOptionPane.showMessageDialog(null, "Bienvenido");
                FrmInvitado ingresos = new FrmInvitado();
                ingresos.setVisible(true);
                ingresos.pack();
                ingresos.getLabel().setText("Bienvenido " + nom + " "+ ape);
                ingresos.getLabel1().setText("Numero de equipo asignado " + num);
                ingresos.getLabel2().setText("Marca del equipo "+ Marca);
                ingresos.getLabel3().setText("Procesador "+Procesador);
                ingresos.getLabel4().setText("Estado equipo "+Estado);
                ingresos.getLabel5().setText("Capacidad de almacenamiento "+Alma);
                ingresos.getLabel6().setText("Memoria ram "+Ram);
                ingresos.getLabel7().setText("Dirección mac "+ Mac);
                ingresos.getLabel8().setText("Accesorios asignados "+Acc);
                ingresos.getLabel9().setText(cor);
                ingresos.getLabel10().setText(pass);
                ingresos.gatLabel11().setText(cod);
            }else if ((!cap.equals("Administrador")) && (!cap.equals("Empleado"))){
                JOptionPane.showMessageDialog(null, "Valide que los campos no esten en blanco o que el usuario y/o contraseña sea valido");
                FrmLogin fr = new FrmLogin();
                fr.setVisible(true);
            }else if(!est.equals("Activo")){
               JOptionPane.showMessageDialog(null, "Esta usuario se encuentra bloqueado por favor contacte al administrador");
               FrmLogin fr = new FrmLogin();
               fr.setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.desconectar();
        }
    }
    
    public void GuardarUsuario(Usuario us) throws Exception{
        ResultSet rs;
        try {
            this.conectar();
            String sql ="INSERT INTO usuario(idUsuario,Nombre,Apellido,Telefono,Direccion,Correo,Contraseña,Tipo,Estado,Ciudad,Contrato,Inventario_idInventario) Values (?,?,?,?,?,?,?,?,?,?,?,?)"; 
            PreparedStatement pre = this.getCon().prepareCall(sql);
            pre.setInt(1, us.getIduser());
            pre.setString(2, us.getNombreuser());
            pre.setString(3, us.getApellidouser());
            pre.setInt(4, us.getTelefonouser());
            pre.setString(5, us.getDireccionuser());
            pre.setString(6, us.getCorreouser());
            pre.setString(7, us.getPassuser());
            pre.setString(8, us.getTipo());
            pre.setString(9, us.getEstadoUser());
            pre.setString(10, us.getCiudaduser());
            pre.setString(11,us.getContratouser());
            pre.setInt(12,us.getLlaveinventario());
            pre.execute();           
            JOptionPane.showMessageDialog(null, "Se ha registrado el usuario y asignado un equipo correctamente");  
        } catch (SQLException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error "+ex);
        }
    }
    
    public ArrayList<Usuario> buscarUsuariosConMatriz()  {
	Conexion conex = new Conexion();
        ArrayList<Usuario> miLista = new ArrayList<Usuario>();
        Usuario user;
        try {
            Statement estatuto = conex.getConnection().createStatement();
            ResultSet rs = estatuto.executeQuery("SELECT idUsuario, Nombre, Apellido,Telefono,Direccion,Correo,Estado,Ciudad,Contrato FROM usuario");

            while (rs.next()) {
                user = new Usuario();
                user.setIduser(rs.getInt("idUsuario"));
                user.setNombreuser(rs.getString("Nombre"));
                user.setApellidouser(rs.getString("Apellido"));
                user.setTelefonouser(rs.getInt("Telefono"));
                user.setDireccionuser(rs.getString("Direccion"));
                user.setCorreouser(rs.getString("Correo"));
                user.setEstadoUser(rs.getString("Estado"));
                user.setCiudaduser(rs.getString("Ciudad"));
                user.setContratouser(rs.getString("Contrato"));
                miLista.add(user);
            }
            rs.close();
            estatuto.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return miLista;
    } 
    public int existeUsuario(String Usuario) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();

        String sql = "SELECT count(idUsuario) FROM usuario WHERE Correo = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, Usuario);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            return 1;
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }
    public boolean esEmail(String correo) {

        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(correo);

        return mather.find();
    }
}
