package hibernate.clase1.entities;

/*

create table concesionarios(
    cn_id bigint not null auto_increment,
    cn_nombre varchar(50) null,
    cn_direccion varchar(50) null,
    primary key (cn_id)
);


 */

import hibernate.clase1.manager.SessionFactoryManager;
import org.hibernate.*;
import org.hibernate.Query;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "concesionarios")
public class Concesionario {
    @Id
    @GeneratedValue
    @Column(name = "cn_id")
    private Long id;
    @Column(name = "cn_nombre")
    private String nombre;
    @Column(name = "cn_direccion")
    private String direccion;

    public Concesionario() {
    }

    public Concesionario(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Concesionario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    public static List<Concesionario> getConcesionarios() {
        Session session = SessionFactoryManager.getSessionFactory().openSession();
        Query query = session.createQuery("from Concesionario");

        return query.list();
    }

    public static Concesionario getConcesionario(Long id) {
        Session session = SessionFactoryManager.getSessionFactory().openSession();

        return (Concesionario)session.get(Concesionario.class, id);
    }

    public static void insert(Concesionario concesionario) {
        Session session = SessionFactoryManager.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(concesionario);
        tx.commit();
    }

    public static void update(Concesionario concesionario) {
        Session session = SessionFactoryManager.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(concesionario);
        tx.commit();
    }

    public static void delete(Concesionario concesionario) {
        Session session = SessionFactoryManager.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(concesionario);
        tx.commit();
    }
}
