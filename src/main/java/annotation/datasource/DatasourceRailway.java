package annotation.datasource;

import annotation.entity.RailwayReservation;
import annotationbysir.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DatasourceRailway {
    public  void storeDataEntry(RailwayReservation railwayReservation){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(RailwayReservation.class);

        //create Session factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(railwayReservation);
            transaction.commit();
        } catch(Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}