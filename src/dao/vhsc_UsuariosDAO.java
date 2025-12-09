/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import bean.VhscUsuarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author u1845853
 */
public class vhsc_UsuariosDAO extends AbstractDAO{

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
        Criteria criteria = session.createCriteria(VhscUsuarios.class);
        criteria.add(Restrictions.eq("idusuarios", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
     public Object listNome(String nome) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VhscUsuarios.class);
        criteria.add(Restrictions.like("vhscNomeUsuario", "%" + nome + "%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listCpf(String cpf) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(VhscUsuarios.class);
    criteria.add(Restrictions.ge("vhscCpf","%" + cpf + "%"));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
}

    public Object listNomeValor(String nome, String cpf) {
    session.beginTransaction();
    Criteria criteria = session.createCriteria(VhscUsuarios.class);
    
    criteria.add(Restrictions.like("vhscNomeUsuario", "%" + cpf + "%"));
    criteria.add(Restrictions.ge("vhscCpf", cpf));
    List lista = criteria.list();
    session.getTransaction().commit();
    return lista;
}

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(VhscUsuarios.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }

    public static void main(String[] args) {
        vhsc_UsuariosDAO vhsc_usuariosDAO = new vhsc_UsuariosDAO();
        vhsc_usuariosDAO.listAll();
    }
}
