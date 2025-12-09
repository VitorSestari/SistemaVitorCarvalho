/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.VhscProdutos;
import bean.VhscUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class VHSC_ControllerConsultasProdutos extends AbstractTableModel {

    private List lstVhscProdutos;

    public void setList(List lstVhscProdutos) {
        this.lstVhscProdutos = lstVhscProdutos;
        this.fireTableDataChanged();
        
    }
    
    public VhscProdutos getBean(int rowIndex) {
        return (VhscProdutos) lstVhscProdutos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVhscProdutos.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VhscProdutos produtos = (VhscProdutos) lstVhscProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return produtos.getVhscIdProduto();
        } else if (columnIndex ==1) {
            return produtos.getVhscAutor();        
        } else if (columnIndex ==2) {
            return produtos.getVhscPreco();
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
            return "Valor Unitario";
        } 
        return "";
    }
}
