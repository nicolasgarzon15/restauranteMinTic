/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.vista;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import restaurante.modelo.Mesero;

/**
 *
 * @author NicolasG
 */
public class ModeloTablaMeseros implements TableModel{

    private final List<Mesero> meseros; 
    private final String[] columnas = new String[] {"Id Mesero", "Documento Mesero", "Nombre Mesero", "Apellido Mesero", "Correo Mesero", "Telefono"};
    private final Class<?> [] clasesColumnas = new Class<?>[]{Integer.class,Integer.class, String.class, String.class, String.class, String.class};
    
        public ModeloTablaMeseros(List<Mesero> meseros) {
        this.meseros = meseros;
    }
    
    @Override
    public int getRowCount() {
        return meseros.size();
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
            return meseros.get(rowIndex).getMeseroId();
        }
        else if (columnIndex==1){
            return meseros.get(rowIndex).getDocumentoMesero();
        }
        else if (columnIndex==2){
            return meseros.get(rowIndex).getNombreMesero();
        }
        else if (columnIndex==3){
            return meseros.get(rowIndex).getApellidoMesero();
        }
        else if (columnIndex==4){
            return meseros.get(rowIndex).getCorreoMesero();
        }else if (columnIndex==5){
            return meseros.get(rowIndex).getTelefonoMesero();
        }
        else{
        return null;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }
    
}
