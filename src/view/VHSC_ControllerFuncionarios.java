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
public class VHSC_ControllerFuncionarios extends AbstractTableModel {

    private List lstFuncionarios;

    public void setList(List lstFuncionarios) {
        this.lstFuncionarios = lstFuncionarios;
    }
    
    public VhscFuncionarios getBean(int rowIndex) {
        return (VhscFuncionarios) lstFuncionarios.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstFuncionarios.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VhscFuncionarios vhscFuncionarios = (VhscFuncionarios) lstFuncionarios.get( rowIndex);
        if ( columnIndex == 0 ){
            return vhscFuncionarios.getVhscIdFuncionario();
        } else if (columnIndex ==1) {
            return vhscFuncionarios.getVhscNome();        
        } else if (columnIndex ==2) {
            return vhscFuncionarios.getVhscCpf();
        } else if (columnIndex ==3) {
            return vhscFuncionarios.getVhscTelefone();
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
