/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


import bean.VhscClientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class VHSC_ControllerConsultasClientes extends AbstractTableModel {

    private List lstVhscClientes;

    public void setList(List lstVhscClientes) {
        this.lstVhscClientes = lstVhscClientes;
        this.fireTableDataChanged();
        
    }
    
    public VhscClientes getBean(int rowIndex) {
        return (VhscClientes) lstVhscClientes.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVhscClientes.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VhscClientes clientes = (VhscClientes) lstVhscClientes.get( rowIndex);
        if ( columnIndex == 0 ){
            return clientes.getVhscIdCliente();
        } else if (columnIndex ==1) {
            return clientes.getVhscNome();        
        } else if (columnIndex ==2) {
            return clientes.getVhscCpf();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Cpf";
        } 
        return "";
    }
}
