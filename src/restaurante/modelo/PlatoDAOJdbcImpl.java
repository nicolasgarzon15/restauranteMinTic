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
public class PlatoDAOJdbcImpl implements IPlatoDAO {

    private Connection conexion;

    private void conectar() {

        String DB_URL = "jdbc:mysql://localhost:3306/restaurante";
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
        String sql = "UPDATE PLATO SET (ID_PLATO=?,TIPO_PLATO=?,NOMBRE_PLATO=?,DESCRIPCION=?,PRECIO=?) WHERE ID_PLATO=?;";
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Plato obtenerPlatoPorId(Integer id) {
        Plato plato = null; 
        this.conectar();
        String sql = "SELECT ¨FROM PLATO wher  id_plato = ? ";
        try {
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            while(res.next()){
                int platoId = res.getInt("ID_PLATO");
                String tipoPlato = res.getString("NOMBRE_TIPO_PLATO");
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
    }

