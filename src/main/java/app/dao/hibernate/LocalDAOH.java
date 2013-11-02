/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.LocalDAO;
import app.model.Local;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David
 */
@Repository("LocalDAO")
public class LocalDAOH extends BaseHibernateDAO implements LocalDAO{

    public List<Local> list() {
        Criteria criteria = this.getSession().createCriteria(Local.class);
        return criteria.list();
    }

    public Local get(Local t) {
        Criteria criteria = this.getSession().createCriteria(Local.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Local) criteria.uniqueResult();
    }

    public void save(Local t) {
        this.getSession().save(t);
    }

    public void update(Local t) {
        this.getSession().update(t);
    }

    public void delete(Local t) {
        this.getSession().delete(t);
    }
    
}
