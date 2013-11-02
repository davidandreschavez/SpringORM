/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.test;

import app.dao.ServicioDAO;
import app.model.Servicio;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrador
 */
public class TestAppORM {
    public static void main(String[] args) {
        
        //TestAppORM.addServicio();
        //TestAppORM.getAll();
        //TestAppORM.deleteServicio();
        TestAppORM.getAll();
        
    }
    
        public static void getAll() {
        ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");

        ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
        List<Servicio> servicios = servicioDAO.list();
        for (Servicio servicio : servicios) {
            System.out.println(servicio.getId()+" "+servicio.getDescripcion() + " " + servicio.getCostoHora());
        }
    }
        
//        public static void getServive(){
//            ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
//            ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
//            
//              Servicio servicio = servicioDAO.get(new Servicio(5));
//        
//                System.out.println(servicio.getId() +" " + servicio.getDescripcion()
//                + " "+ servicio.getCostoHora());
//        }
        
        
        private static void addServicio(){
              ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
              ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
              
              Servicio servicio = new Servicio();
              servicio.setDescripcion("Gincanas");
              servicio.setCostoHora(1504.99d);
              
              servicioDAO.save(servicio);
        }
        
//        private static void updateServicio(){
//            ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
//            ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
//            Servicio servicio = new Servicio();
//            servicio.setId(1);
//            servicio.setDescripcion("Campeonatos Interprovicionales ");
//            servicio.setCostoHora(145.9d);
//            servicioDAO.update(servicio);
//            
//        }
//        private static void deleteServicio(){
//              ApplicationContext context = new ClassPathXmlApplicationContext("database.xml");
//              ServicioDAO servicioDAO = (ServicioDAO) context.getBean("servicioDAO");
//              
//              Servicio servicio = new Servicio();
//              servicio.setId(3);
//              servicioDAO.delete(servicio);
//              
//        }
//        
        
}
