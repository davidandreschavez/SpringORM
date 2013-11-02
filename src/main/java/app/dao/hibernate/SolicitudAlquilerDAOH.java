/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.SolicitudAlquilerDAO;
import app.model.SolicitudAlquiler;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David
 */
@Repository("SolicitudAlquilerDAO")
public class SolicitudAlquilerDAOH extends BaseHibernateDAO implements SolicitudAlquilerDAO{

    public List list() {
        Criteria criteria = this.getSession().createCriteria(SolicitudAlquiler.class);
        return criteria.list();
    
    }

    public Object get(Object t) {
        Criteria criteria = this.getSession().createCriteria(SolicitudAlquiler.class);
        criteria.add(Restrictions.eq("id",t.getId()));
        return (SolicitudAlquiler) criteria.uniqueResult();
    }

    public void save(Object t) {
        this.getSession().update(t);
    }

    public void update(Object t) {
        this.getSession().update(t);
    }

    public void delete(Object t) {
        this.getSession().delete(t);
    }
    
}
