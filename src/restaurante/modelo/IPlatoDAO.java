/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.modelo;

import java.util.List;

/**
 *
 * @author Valeria
 */
public interface IPlatoDAO {
    
    public List<Plato> obtenerTodosLosPlatos();
    
    public Plato obtenerPlatoPorId(Integer id);
    
    public void insertarPlato(Plato plato);
    
    public void actualizarPlato(Plato plato, int platoId);
    
    public void eliminarPlato(Plato plato);
    
    
}
