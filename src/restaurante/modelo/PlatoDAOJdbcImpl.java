/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valeria
 */
public class PlatoDAOJdbcImpl implements IMeseroDAO,IPlatoDAO{

    private Connection conexion;

    private void conectar() {

        String DB_URL = "jdbc:mysql://127.0.0.1:3306/restaurante";
        String DB_USER = "root";
        String DB_PASSWORD = "1204";
        String DB_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(DB_DRIVER_CLASS);
            conexion = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Conectado");
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR AL CONECTAR" + e.getMessage());
        } catch (SQLException e) {
            System.out.println("ERROR DE BASE DE DATOS AL CONECTAR"+e.getMessage());
        }
    }

    private void desconectar() {
        if(conexion != null){
            try{
                conexion.close();
            }
            catch(SQLException e){
                System.out.println("ERROR AL DESCONECTAR"+e.getMessage());
            }
        }
    }

    @Override
    public List<Plato> obtenerTodosLosPlatos() {
        
        List<Plato> platos = new ArrayList<Plato>();
        this.conectar();
        String sql = "select id_plato, nombre_tipo_plato,nombre_plato,descripcion,precio from plato,tipo_plato where tipo_plato = id_tipo_plato;";
        try {
            Statement statement = conexion.createStatement();
            ResultSet res = statement.executeQuery(sql);
            while(res.next()){
                int platoId = res.getInt("ID_PLATO");
                String tipoPlato = res.getString("NOMBRE_TIPO_PLATO");
                String nombrePlato = res.getString("NOMBRE_PLATO");
                String descripcion = res.getString("DESCRIPCION");
                double precio = res.getDouble("PRECIO");
                Plato plato = new Plato(platoId, tipoPlato, nombrePlato, descripcion, precio);
                platos.add(plato);
            }
        } catch(SQLException e){
            System.out.println("Error al consultar" + e.getMessage());
            
        }
        return platos;
    }

    @Override
    public void insertarPlato(Plato plato) {
        this.conectar(); 
        String sql = "INSERT INTO PLATO (ID_PLATO,TIPO_PLATO,NOMBRE_PLATO,DESCRIPCION,PRECIO) VALUES (?,?,?,?,?);";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, plato.getPlatoId());
            ps.setInt(2, plato.getIdTipoPlato());
            ps.setString(3, plato.getNombrePlato());
            ps.setString(4, plato.getDescripcion());
            ps.setDouble(5, plato.getPrecio());
            int filasInsertadas = ps.executeUpdate();
            if(filasInsertadas>0){
                System.out.println("Se insertó un nuevo plato al menú");
            }
            //Completar
        } catch (SQLException ex) {
            Logger.getLogger(PlatoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void actualizarPlato(Plato plato, int platoId) {
        this.conectar(); 
        String sql = "UPDATE PLATO SET ID_PLATO=?,TIPO_PLATO=?,NOMBRE_PLATO=?,DESCRIPCION=?,PRECIO=? WHERE ID_PLATO=?;";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, plato.getPlatoId());
            ps.setInt(2, plato.getIdTipoPlato());
            ps.setString(3, plato.getNombrePlato());
            ps.setString(4, plato.getDescripcion());
            ps.setDouble(5, plato.getPrecio());
            ps.setInt(6, platoId);
            int filasActualizadas = ps.executeUpdate();
            if(filasActualizadas>0){
                System.out.println("Se actualizó un nuevo plato al menú");
            }
            //Completar
        } catch (SQLException ex) {
            Logger.getLogger(PlatoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarPlato(Plato plato) {
        this.conectar(); 
        String sql = "DELETE FROM PLATO WHERE ID_PLATO=?;";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, plato.getPlatoId());
            int filasEliminadas = ps.executeUpdate();
            if(filasEliminadas>0){
                System.out.println("Se eliminó un plato del menú");
            }
            //Completar
        } catch (SQLException ex) {
            Logger.getLogger(PlatoDAOJdbcImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Plato obtenerPlatoPorId(Integer id) {
        Plato plato = null; 
        this.conectar();
        String sql = "SELECT * FROM PLATO WHERE id_plato = ? ";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            while(res.next()){
                int platoId = res.getInt("ID_PLATO");
                int tipoPlato = res.getInt("TIPO_PLATO");
                String nombrePlato = res.getString("NOMBRE_PLATO");
                String descripcion = res.getString("DESCRIPCION");
                double precio = res.getDouble("PRECIO");
                plato = new Plato(platoId, tipoPlato, nombrePlato, descripcion, precio);
            }
        } catch(SQLException e){
            System.out.println("Error al consultar" + e.getMessage());
            
        }
        return plato;
    }

    @Override
    public List<Mesero> obtenerTodosLosMeseros() {
        List<Mesero> meseros = new ArrayList<Mesero>();
        this.conectar();
        String sql = "select * from mesero;";
        try {
            Statement statement = conexion.createStatement();
            ResultSet res = statement.executeQuery(sql);
            while(res.next()){
                int meseroId = res.getInt("ID_MESERO");
                int documentoId = res.getInt("DOCUMENTO_MESERO");
                String nombreMesero = res.getString("NOMBRE_MESERO");
                String apellidoMesero = res.getString("APELLIDO_MESERO");
                String correoMesero = res.getString("CORREO_MESERO");
                String telefonoMesero = res.getString("TELEFONO");
                Mesero mesero = new Mesero(meseroId, documentoId, nombreMesero, apellidoMesero, correoMesero, telefonoMesero);
                meseros.add(mesero);
            }
        } catch(SQLException e){
            System.out.println("Error al consultar meseros" + e.getMessage());
            
        }
        return meseros;
    }

    @Override
    public Mesero obtenerMeseroPorId(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarMesero(Mesero mesero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarMesero(Mesero mesero, int meseroId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarMesero(Mesero mesero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mesero> obtenerEmpleadoDelMes() {
        List<Mesero> meseros = new ArrayList<Mesero>();
        this.conectar();
        String sql = "select Nombre_mesero,apellido_mesero,documento_mesero,telefono,cantidad_pedidos, max(sumatoria) as sumatoria from (SELECT Nombre_mesero,apellido_mesero,documento_mesero,telefono, count(*) as cantidad_pedidos,sum(precio) as sumatoria from mesero,orden,plato where mesero=id_mesero AND plato=id_plato group by nombre_mesero) as tabla;";
        try {
            Statement statement = conexion.createStatement();
            ResultSet res = statement.executeQuery(sql);
            while(res.next()){
                String nombreMesero = res.getString("Nombre_mesero");
                String apellidoMesero = res.getString("apellido_mesero");
                int documentoMesero = res.getInt("documento_mesero");
                String telefono = res.getString("telefono");
                int cantidad = res.getInt("cantidad_pedidos");
                float sumatoria = res.getFloat("sumatoria");
                Mesero mesero = new Mesero(nombreMesero, apellidoMesero, documentoMesero, telefono, cantidad, sumatoria);
                meseros.add(mesero);
            }
        } catch(SQLException e){
            System.out.println("Error al consultar meseros" + e.getMessage());
            
        }
        return meseros;
    }
    }

