package lt.viko.eif.svyrydenko.d.hospital.Util;

import lt.viko.eif.svyrydenko.d.hospital.Models.Hospital;
import org.h2.tools.Server;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
    private static Transaction transaction;
    private static List<Hospital> hospitals = new ArrayList<>();
    private static Server server;
    private HibernateUtil() {}
    public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
        try {
            //create registry
            registry = new StandardServiceRegistryBuilder().configure().build();

            //create MetadataSources
            MetadataSources sources = new MetadataSources(registry);

            //Create metadata
            Metadata metadata = sources.getMetadataBuilder().build();

            //Create SessionFactory
            sessionFactory = metadata.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            e.printStackTrace();
            if (registry != null) {
                StandardServiceRegistryBuilder.destroy(registry);
            }
        }
    }
    return sessionFactory;
}
    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public static void saveToDatabase(List<Hospital> hospitals)  {
        transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save or update the hospital objects
            for (Hospital hospital : hospitals) {
                session.saveOrUpdate(hospital);
            }
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static List<Hospital> getFromDatabase() {
        server = null;
        transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            hospitals = session.createQuery("from Hospital", Hospital.class).list();
            server = Server.createTcpServer().start();
            System.in.read();
        } catch(Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            server.shutdown();
        }
        return hospitals;
    }
}

