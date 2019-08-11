package pl.strefakursow.Entity;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.Arrays;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company")
    private Integer idCompany;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Integer value;

    //@OneToOne(cascade = CascadeType.PERSIST) - we only have to persist the Company Entity, and the associated CompanyDetails is persisted as well
    @OneToOne(cascade = {CascadeType.REMOVE,CascadeType.PERSIST}) // jeżeli zostanie usunięte Company to zostanie usunięte także CompanyDetails
    @JoinColumn(name = "id_company_detail")
    private CompanyDetail companyDetail;

    public CompanyDetail getCompanyDetail() {
        return companyDetail;
    }

    public void setCompanyDetail(CompanyDetail companyDetail) {
        this.companyDetail = companyDetail;
    }

    public Company() {
    }

    public Company(Integer idCompany, String name, Integer value) {
        this.idCompany = idCompany;
        this.name = name;
        this.value = value;
    }

    public Company(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Company{" +
                "idCompany=" + idCompany +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }


}