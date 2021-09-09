/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.controlador;

 

import java.util.ArrayList;
import java.util.List;
import restaurante.modelo.IPlatoDAO;
import restaurante.modelo.Plato;
import restaurante.modelo.PlatoDAOJdbcImpl;

public class PlatoControlador {
    
    private final List<Plato> listaPlato;
    IPlatoDAO daoPlato = new PlatoDAOJdbcImpl();
    
  
    public PlatoControlador(){
        
    listaPlato = new ArrayList<Plato>();
    }
    
    public List <Plato> obtenerTodosLosPlatos(){
        return daoPlato.obtenerTodosLosPlatos();
    }
    
    public void insertarPlato(Plato plato){
        daoPlato.insertarPlato(plato);
    }
    
    public Plato obtenerPlatoPorId(Integer id){
        return daoPlato.obtenerPlatoPorId(id);
    }
    
    public void actualizarPlato(Plato plato, int platoId) {
        daoPlato.actualizarPlato(plato, platoId);
    }
    
    public void eliminarPlato(Plato plato){
        daoPlato.eliminarPlato(plato);
    }
    
}
