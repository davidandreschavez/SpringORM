/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.SocioDAO;
import app.model.Socio;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David
 */
@Repository("SocioDAO")
public class SocioDAOH extends BaseHibernateDAO implements SocioDAO {
    
    public List<Socio> list() {
        Criteria criteria = this.getSession().createCriteria(Socio.class);
        return criteria.list();
    }
    
    public Socio get(Socio t) {
        Criteria criteria = this.getSession().createCriteria(Socio.class);
        criteria.add(Restrictions.eq("id",t.getId()));
        return (Socio) criteria.uniqueResult();
    }
    
    public void save(Socio t) {
        this.getSession().update(t);
    }
    
    public void update(Socio t) {
        this.getSession().update(t);
    }
    
    public void delete(Socio t) {
        this.getSession().delete(t);
    }
}
