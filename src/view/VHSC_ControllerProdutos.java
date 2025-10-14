/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import bean.VhscProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class VHSC_ControllerProdutos extends AbstractTableModel {

    private List lstProdutos;

    public void setList(List lstProdutos) {
        this.lstProdutos = lstProdutos;
    }
    
    public VhscProdutos getBean(int rowIndex) {
        return (VhscProdutos) lstProdutos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstProdutos.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VhscProdutos vhscUsuarios = (VhscProdutos) lstProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return vhscUsuarios.getVhscIdProduto();
        } else if (columnIndex ==1) {
            return vhscUsuarios.getVhscTitulo();        
        } else if (columnIndex ==2) {
            return vhscUsuarios.getVhscAutor();
        } else if (columnIndex ==3) {
            return vhscUsuarios.getVhscQuantidade();
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
            return "Apelido";
        } else if ( columnIndex == 3) {
            return "Cpf";
        } 
        return "";
    }
}
