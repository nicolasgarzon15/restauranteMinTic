
package restaurante.modelo;

import java.util.List;

/**
 *
 * @author NicolasG
 */
public interface IMeseroDAO {
    public List<Mesero> obtenerTodosLosMeseros();
    
    public List<Mesero> obtenerEmpleadoDelMes();
    
    public Mesero obtenerMeseroPorId(Integer id);
    
    public void insertarMesero(Mesero mesero);
    
    public void actualizarMesero(Mesero mesero, int meseroId);
    
    public void eliminarMesero(Mesero mesero);
}
