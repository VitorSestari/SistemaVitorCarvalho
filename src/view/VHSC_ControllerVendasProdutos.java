/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import bean.VhscVendasProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author user
 */
public class VHSC_ControllerVendasProdutos extends AbstractTableModel {
     private List lstVendasProdutos;

    public void setList(List lstVendasProdutos) {
        this.lstVendasProdutos = lstVendasProdutos;
        
        this.fireTableDataChanged();
    }
    
    public VhscVendasProdutos getBean(int rowIndex) {
        return (VhscVendasProdutos) lstVendasProdutos.get(rowIndex);
    }

    public void addBean(VhscVendasProdutos vhscVendasProdutos) {
        lstVendasProdutos.add(vhscVendasProdutos);
        this.fireTableDataChanged();
    }
    
    public void removeBean(int rowIndex) {
        lstVendasProdutos.remove(rowIndex);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lstVendasProdutos.size();                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VhscVendasProdutos vhscVendasProdutos = (VhscVendasProdutos) lstVendasProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return vhscVendasProdutos.getVhscProdutos().getVhscIdProduto();
        } else if (columnIndex ==1) {
            return vhscVendasProdutos.getVhscProdutos().getVhscAutor();
        } else if (columnIndex ==2) {
            return vhscVendasProdutos.getVhscQuantidade();
        } else if (columnIndex ==3) {
            return vhscVendasProdutos.getVhscPrecoUnitario();
        }else if (columnIndex ==4) {
            return vhscVendasProdutos.getVhscPrecoUnitario()*vhscVendasProdutos.getVhscQuantidade();
        }
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Produto";         
        } else if ( columnIndex == 2) {
            return "Quantidade";
        } else if ( columnIndex == 3) {
            return "Valor Unitário";
        } else if ( columnIndex == 4) {
            return "Total";
        } 
        return "";
    }
}
