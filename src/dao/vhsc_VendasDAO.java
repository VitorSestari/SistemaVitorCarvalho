/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.VhscProdutos;
import bean.VhscVendas;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import tools.VHSC_Util;



/**
 *
 * @author u1845853
 */
public class vhsc_VendasDAO extends AbstractDAO{

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();        
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();        
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();        
        session.delete(object);
        session.getTransaction().commit();        
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VhscVendas.class);
        criteria.add(Restrictions.eq("idvendas", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
     public Object listFormaPagamento(String FormaPagamento) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VhscVendas.class);
        criteria.add(Restrictions.like("vhscFormaPagamento", "%" + FormaPagamento + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listValorTotal(double ValorTotal) {
    session.beginTransaction();
        Criteria criteria = session.createCriteria(VhscVendas.class);
         criteria.add(Restrictions.ge("vhscValorTotal", ValorTotal));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
}


  public Object listFormaPagamentoValor(String FormaPagamento, double valor) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(VhscVendas.class);
    criteria.add(Restrictions.like("vhscFormaPagamento", "%" + FormaPagamento + "%"));
    criteria.add(Restrictions.ge("vhscValorTotal", valor));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
}



    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VhscVendas.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }

    public static void main(String[] args) {
        vhsc_VendasDAO vhsc_vendasDAO = new vhsc_VendasDAO();
        vhsc_vendasDAO.listAll();
    }
}
