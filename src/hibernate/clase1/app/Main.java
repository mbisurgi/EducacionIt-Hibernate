package hibernate.clase1.app;

import hibernate.clase1.entities.Auto;
import hibernate.clase1.entities.Concesionario;
import hibernate.clase1.manager.SessionFactoryManager;
import hibernate.clase2.repository.AutoRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Auto auto1 = new Auto("Peugeot", "208", 2015, 360000f, Date.valueOf("2002-01-01"));
        Auto auto2 = new Auto("Ford", "Focus", 2015, 120000f, Date.valueOf("2003-01-01"));
        Auto auto3 = new Auto("Peugeot", "308", 2010, 300000f, Date.valueOf("2004-01-01"));



        SessionFactoryManager sessionFactoryManager = new SessionFactoryManager();
        SessionFactory sessionFactory = sessionFactoryManager.getSessionFactory();

        AutoRepository repository = new AutoRepository(sessionFactory);

        for (Auto auto: repository.getAllOrderFecha()) {
            System.out.println(auto);
        }

        for (Auto auto: repository.getByRangoFecha(Date.valueOf("2002-01-01"), Date.valueOf("2003-01-01"))) {
            System.out.println(auto);
        }

        for (Auto auto: repository.getByModelo(2010)) {
            System.out.println(auto);
        }

        //Session session = SessionFactoryManager.getSessionFactory().openSession();

        //Transaction tx = session.beginTransaction();

        //session.save(auto1);
        //session.save(auto2);
        //session.save(auto3);
        //session.update(auto3);
        //session.delete(auto2);

        //tx.commit();

        /*Auto auto = (Auto)session.get(Auto.class, 3L);

        System.out.println(auto);

        Query query = session.createQuery("from Auto");
        List<Auto> autos = query.list();

        autos.forEach(System.out::println);

        Concesionario concesionario1 = new Concesionario("Espasa SA", "Loria 566");
        Concesionario concesionario2 = new Concesionario("Guido Guidi SA", "Esparza 1432");

        Concesionario.insert(concesionario1);
        Concesionario.insert(concesionario2);

        concesionario2.setNombre("Guido Guidi SRL");

        Concesionario.update(concesionario2);


        Concesionario.getConcesionarios().forEach(System.out::println);*/
    }
}
