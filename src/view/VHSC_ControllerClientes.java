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
public class VHSC_ControllerClientes extends AbstractTableModel {

    private List lstClientes;

    public void setList(List lstClientes) {
        this.lstClientes = lstClientes;
    }
    
    public VhscClientes getBean(int rowIndex) {
        return (VhscClientes) lstClientes.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstClientes.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VhscClientes vhscClientes = (VhscClientes) lstClientes.get( rowIndex);
        if ( columnIndex == 0 ){
            return vhscClientes.getVhscIdCliente();
        } else if (columnIndex ==1) {
            return vhscClientes.getVhscNome();        
        } else if (columnIndex ==2) {
            return vhscClientes.getVhscCpf();
        } else if (columnIndex ==3) {
            return vhscClientes.getVhscTelefone();
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
        } else if ( columnIndex == 3) {
            return "Telefone";
        } 
        return "";
    }
}
