/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.vista;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import restaurante.modelo.Plato;

/**
 *
 * @author Valeria
 */
public class ModeloTablaPlatos implements TableModel {

    private final List<Plato> platos; 
    private final String[] columnas = new String[] {"Id plato", "Tipo plato", "Nombre plato", "Descripcion", "Precio"};
    private final Class<?> [] clasesColumnas = new Class<?>[]{Integer.class, String.class, String.class, String.class, Double.class};

    public ModeloTablaPlatos(List<Plato> platos) {
        this.platos = platos;
    }

    
    
    @Override
    public int getRowCount() {
        return platos.size();
    }

    @Override
    public int getColumnCount() {
         return columnas.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
         return columnas[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return clasesColumnas[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        if(columnIndex == 0){
            return platos.get(rowIndex).getPlatoId();
        }
        else if (columnIndex==1){
            return platos.get(rowIndex).getTipoPlato();
        }
        else if (columnIndex==2){
            return platos.get(rowIndex).getNombrePlato();
        }
        else if (columnIndex==3){
            return platos.get(rowIndex).getDescripcion();
        }
        else if (columnIndex==4){
            return platos.get(rowIndex).getPrecio();
        }
        else{
        return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //Colocar valor en la tabla 
        /*if(columnIndex == 0){
            platos.get(rowIndex).setPlatoId((int) aValue);
        }*/
    }

    @Override
    public void addTableModelListener(TableModelListener tl) {
  
    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {
  
    }
    
}
