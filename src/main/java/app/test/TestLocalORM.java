/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.test;

import app.dao.LocalDAO;
import app.model.Local;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author David
 */
public class TestLocalORM {
    public static void main(String[] args) {
        TestLocalORM.addLocal();
        TestLocalORM.getAllLocal();
    }
  
    private static void getAllLocal(){
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");

        LocalDAO localDAO = (LocalDAO) context.getBean("localDAO");
        List<Local> locales = localDAO.list();
        for (Local local : locales) {
            System.out.println(local.getId()+" "+local.getDireccion() + " " + local.getDescripcion() + " "+
                    local.getEstado()+" "+local.getTelefono());
        }        
    }
    
    private static void addLocal(){
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
        LocalDAO localDAO = (LocalDAO) context.getBean("localDAO");
        Local local = new Local();
        local.setDescripcion("Local Principal");
        local.setDireccion("Av Argentina 1275 Lima");
        local.setEstado(1);
        local.setTelefono("01 3310200");
        local.setCampo(null);
        localDAO.save(local);
        
        }
    
}
