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
public class VHSC_ControllerConsultasVendas extends AbstractTableModel {

    private List lstVhscVendas;

    public void setList(List lstVhscVendas) {
        this.lstVhscVendas = lstVhscVendas;
        this.fireTableDataChanged();
        
    }
    
    public VhscVendas getBean(int rowIndex) {
        return (VhscVendas) lstVhscVendas.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVhscVendas.size();
                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VhscVendas vendas = (VhscVendas) lstVhscVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return vendas.getVhscIdVenda();
        } else if (columnIndex ==1) {
            return vendas.getVhscClientes();        
        } else if (columnIndex ==2) {
            return vendas.getVhscFuncionarios();
        } 
         else if (columnIndex ==3) {
            return vendas.getVhscValorTotal();        
        } else if (columnIndex ==4) {
            return vendas.getVhscFormaPagamento();
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
            return "Nome Funcionario";
         
         } else if ( columnIndex == 3) {
            return "Valor Total";         
        } else if ( columnIndex == 4) {
            return "Forma de pagamento";
        } 
        return "";
    }
}
