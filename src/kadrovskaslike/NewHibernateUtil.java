package kadrovskaslike;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author LozanciZ
 */
public class NewHibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;
    
    static {
        try {
            
            URL = Login.url;
            USERNAME = Login.userName;
            PASSWORD = Login.pass;

            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            Configuration configuration = new Configuration();
            
            configuration.setProperty("hibernate.connection.url", URL);
            configuration.setProperty("hibernate.connection.username", USERNAME);
            configuration.setProperty("hibernate.connection.password", PASSWORD);
            
            configuration.configure();
            
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build(); 
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory(String url,String userName,String pass) {
    	
    	URL = url;
    	USERNAME = userName;
    	PASSWORD = pass;
    	
        return sessionFactory;
    }
    
    public static SessionFactory getSessionFactory() {   	
        return sessionFactory;
    }    
    
    public static void SetSessionFactory(String url,String userName,String pass) {
       
    	URL = url;
    	USERNAME = userName;
    	PASSWORD = pass;
        
        try {
           
            Configuration configuration = new Configuration();

            configuration.setProperty("hibernate.connection.url", URL);
            configuration.setProperty("hibernate.connection.username", USERNAME);
            configuration.setProperty("hibernate.connection.password", PASSWORD);

            configuration.configure();      
            
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build(); 
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);            

       } catch (Throwable ex) {
         // Log exception!
         throw new ExceptionInInitializerError(ex);
       }
     }   
    
    
    
}
