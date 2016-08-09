package hibernate.clase2.repository;

import hibernate.clase1.entities.Auto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

public class AutoRepository {
    private final SessionFactory factory;

    public AutoRepository(SessionFactory factory) {
        this.factory = factory;
    }

    public Auto insert(Auto auto) {
        return null;
    }

    public void update(Auto auto) {

    }

    public void delete(Auto auto) {

    }

    public Auto getById(Long id) {
        return null;
    }

    public List<Auto> getAll() {
        return null;
    }

    public List<Auto> getAllOrderFecha() {
        Session session = factory.openSession();
        List<Auto> autos = session.createQuery("from Auto a order by a.fechaVenta desc").list();
        session.close();

        return autos;
    }

    public List<Auto> getByRangoFecha(Date desde, Date hasta) {
        Session session = factory.openSession();
        List<Auto> autos = session.createCriteria(Auto.class)
                            .add(Restrictions.between("fechaVenta", desde, hasta))
                            .list();
        session.close();

        return autos;
    }

    public List<Auto> getByModelo(Integer anio) {
        Session session = factory.openSession();
        List<Auto> autos = session.createCriteria(Auto.class)
                .add(Restrictions.eq("anio", anio))
                .list();
        session.close();

        return autos;
    }
}
