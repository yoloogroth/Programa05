/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.programa05;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Yolotzin Groth Hdez
 */
public class DAOEmpleado implements IDAOGeneral<Empleado, Long>{

    @Override
    public Empleado create(Empleado p) {
              Session session=HibernateUtil.getSession();
              Transaction t=session.beginTransaction();
              
              session.save(p);
              
              t.commit();
              session.close();
              return p;
    }

    @Override
    public boolean delete(Long id) {
        boolean bandera=false;
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        
        Empleado emp=session.get(Empleado.class, id);
        if (emp!=null){
            session.delete(emp);
            t.commit();
            bandera=true;
        }
              
        session.close();
        
        return bandera;
    }

    @Override
    public Empleado update(Empleado p, Long id) {
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        
        
        Empleado emp=session.get(Empleado.class, String.valueOf(id));
        if (emp!=null){
            session.update(p);
        }
        session.close();
        return p;
    }

    @Override
    public List<Empleado> findAll() {
        Session session=HibernateUtil.getSession();
        Transaction t=session.beginTransaction();
        
        List <Empleado> Lemp;
        
        Lemp=session.createQuery("From ejemplo").list();
        
        
        t.commit();
        session.close();
        
        return Lemp;
        
    }

    @Override
    public Empleado findbyID(Long id, Empleado t) {
        Session session=HibernateUtil.getSession();
        Transaction a=session.beginTransaction();
          
        t=session.get(Empleado.class, id);
        a.commit();
        session.close();
        return t;
          
        
       
    }


}