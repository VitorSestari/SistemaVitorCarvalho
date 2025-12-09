/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;


import bean.VhscUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Marcos
 */
public class VHSC_ControllerConsultasUsuarios extends AbstractTableModel {

    private List lstVhscUsuarios;

    public void setList(List lstVhscUsuarios) {
        this.lstVhscUsuarios = lstVhscUsuarios;
        this.fireTableDataChanged();
        
    }
    
    public VhscUsuarios getBean(int rowIndex) {
        return (VhscUsuarios) lstVhscUsuarios.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return lstVhscUsuarios.size();
                
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VhscUsuarios usuarios = (VhscUsuarios) lstVhscUsuarios.get( rowIndex);
        if ( columnIndex == 0 ){
            return usuarios.getVhscIdUsuario();
        } else if (columnIndex ==1) {
            return usuarios.getVhscNomeUsuario();        
        } else if (columnIndex ==2) {
            return usuarios.getVhscCpf();
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
