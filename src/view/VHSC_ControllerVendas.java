/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.VhscVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class VHSC_ControllerVendas extends AbstractTableModel {

    private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
    }
    
    public VhscVendas getBean(int rowIndex) {
        return (VhscVendas) lstVendas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVendas.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VhscVendas vhscVendas = (VhscVendas) lstVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return vhscVendas.getVhscIdVenda();
        } else if (columnIndex ==1) {
            return vhscVendas.getVhscNomeCliente();        
        } else if (columnIndex ==2) {
            return vhscVendas.getVhscNomeLivro();
        } else if (columnIndex ==3) {
            return vhscVendas.getVhscDataVenda();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome Cliente";         
        } else if ( columnIndex == 2) {
            return "Nome Livro";
        } else if ( columnIndex == 3) {
            return "Data de venda";
        } 
        return "";
    }
}
