/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


import bean.VhscFuncionarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class VHSC_ControllerConsultasFuncionarios extends AbstractTableModel {

    private List lstVhscFuncionarios;

    public void setList(List lstVhscFuncionarios) {
        this.lstVhscFuncionarios = lstVhscFuncionarios;
        this.fireTableDataChanged();
        
    }
    
    public VhscFuncionarios getBean(int rowIndex) {
        return (VhscFuncionarios) lstVhscFuncionarios.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVhscFuncionarios.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VhscFuncionarios funcionarios = (VhscFuncionarios) lstVhscFuncionarios.get( rowIndex);
        if ( columnIndex == 0 ){
            return funcionarios.getVhscIdFuncionario();
        } else if (columnIndex ==1) {
            return funcionarios.getVhscNome();        
        } else if (columnIndex ==2) {
            return funcionarios.getVhscCpf();
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
            return "Id";
        } 
        return "";
    }
}
