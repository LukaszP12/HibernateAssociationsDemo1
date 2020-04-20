package pl.strefakursow.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_property")
    private Integer id_property;

    @Column(name = "city")
    private String city;

    @Column(name = "room_number")
    private Integer room_number;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "id_company")
    private Company company;

    public Property() {
    }

    public Property(String city, Integer room_number) {
        this.city = city;
        this.room_number = room_number;
    }

    public Integer getId_property() {
        return id_property;
    }

    public void setId_property(Integer id_property) {
        this.id_property = id_property;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getRoom_number() {
        return room_number;
    }

    public void setRoom_number(Integer room_number) {
        this.room_number = room_number;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id_property=" + id_property +
                ", city='" + city + '\'' +
                ", room_number=" + room_number +
                ", company=" + company +
                '}';
    }
}