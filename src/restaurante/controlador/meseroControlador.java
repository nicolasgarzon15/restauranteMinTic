/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controlador;

import java.util.ArrayList;
import java.util.List;
import restaurante.modelo.IMeseroDAO;
import restaurante.modelo.Mesero;
import restaurante.modelo.PlatoDAOJdbcImpl;

/**
 *
 * @author NicolasG
 */
public class meseroControlador {
        
    private final List<Mesero> listaMesero;
    IMeseroDAO daoMesero = new PlatoDAOJdbcImpl();
    
  
    public meseroControlador(){
        
    listaMesero = new ArrayList<Mesero>();
    }
    
    public List <Mesero> obtenerTodosLosMeseros(){
        return daoMesero.obtenerTodosLosMeseros();
    }
    
    public List <Mesero> obtenerMeseroMes(){
        return daoMesero.obtenerEmpleadoDelMes();
    }
    
    public void insertarPlato(Mesero mesero){
        daoMesero.insertarMesero(mesero);
    }
    
    public Mesero obtenerPlatoPorId(Integer id){
        return daoMesero.obtenerMeseroPorId(id);
    }
    
    public void actualizarPlato(Mesero mesero, int meseroId) {
        daoMesero.actualizarMesero(mesero, meseroId);
    }
    
    public void eliminarPlato(Mesero mesero){
        daoMesero.eliminarMesero(mesero);
    }
}
