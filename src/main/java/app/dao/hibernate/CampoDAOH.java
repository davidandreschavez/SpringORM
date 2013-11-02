/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.CampoDAO;
import app.model.Campo;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David
 */
@Repository("CampoDAO")
public class CampoDAOH extends BaseHibernateDAO implements CampoDAO{

    public List<Campo> list() {
        Criteria criteria = this.getSession().createCriteria(Campo.class);
        return criteria.list();
    }

    public Campo get(Campo t) {
        Criteria criteria = this.getSession().createCriteria(Campo.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return(Campo) criteria.uniqueResult();
    }

    public void save(Campo t) {
        this.getSession().update(t);
    }

    public void update(Campo t) {
        this.getSession().update(t);
    }

    public void delete(Campo t) {
        this.getSession().delete(t);
    }    
}
