package hibernate.clase1.app;

import hibernate.clase1.entities.Auto;
import hibernate.clase1.manager.SessionFactoryManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Auto auto1 = new Auto("Peugeot", "208", 2015, 360000f);
        Auto auto2 = new Auto("Ford", "Focus", 2015, 120000f);
        Auto auto3 = new Auto("Peugeot", "308", 2010, 300000f);
        auto2.setId(2L);
        auto3.setId(3L);

        SessionFactoryManager sessionFactoryManager = new SessionFactoryManager();
        SessionFactory sessionFactory = sessionFactoryManager.getSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        //session.save(auto1);
        //session.save(auto2);
        //session.save(auto3);
        //session.update(auto3);
        //session.delete(auto2);

        tx.commit();

        Auto auto = (Auto)session.get(Auto.class, 3L);

        System.out.println(auto);

        Query query = session.createQuery("from Auto");
        List<Auto> autos = query.list();

        autos.forEach(System.out::println);
    }
}
