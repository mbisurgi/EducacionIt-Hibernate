package hibernate.clase1.entities;

import javax.persistence.*;

/*

create table autos(
    au_id bigint not null auto_increment,
    au_marca varchar(50) null,
    au_modelo varchar(50) null,
    au_anio int(4) not null default 0,
    au_precio float not null default 0.0,
    primary key (au_id)
);

 */

@Entity
@Table(name = "autos")
public class Auto {
    @Id
    @GeneratedValue
    @Column(name = "au_id")
    private Long id;
    @Column(name = "au_marca")
    private String marca;
    @Column(name = "au_modelo")
    private String modelo;
    @Column(name = "au_anio")
    private Integer anio;
    @Column(name = "au_precio")
    private Float precio;

    public Auto() {
    }

    public Auto(String marca, String modelo, Integer anio, Float precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", precio=" + precio +
                '}';
    }
}
