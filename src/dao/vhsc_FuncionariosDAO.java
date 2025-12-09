/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.VhscFuncionarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author u1845853
 */
public class vhsc_FuncionariosDAO extends AbstractDAO{

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
        Criteria criteria = session.createCriteria(VhscFuncionarios.class);
        criteria.add(Restrictions.eq("idfuncionarios", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
     public Object listNomeFuncionario(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VhscFuncionarios.class);
        criteria.add(Restrictions.like("vhscNome", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listCpfFuncionario(String cpf) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(VhscFuncionarios.class);
    criteria.add(Restrictions.like("vhscCpf",cpf + "%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
}

    public Object listNomeCpf(String nome, String cpf) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(VhscFuncionarios.class);
    
    criteria.add(Restrictions.like("vhscNome", "%" + nome + "%"));
    criteria.add(Restrictions.like("vhscCpf", cpf + "%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
}

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VhscFuncionarios.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }

    public static void main(String[] args) {
        vhsc_FuncionariosDAO vhsc_funcionariosDAO = new vhsc_FuncionariosDAO();
        vhsc_funcionariosDAO.listAll();
    }
}
