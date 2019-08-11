package pl.strefakursow.Entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "company_detail")
public class CompanyDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company_detail")
    private Integer idCompanyDetail;

    @Column(name = "residence")
    private String residence;

    @Column(name = "employee_number")
    private Integer employeeNumber;

    @OneToOne(mappedBy = "companyDetail",cascade = CascadeType.ALL) // jak w drugiej klasie nazwy sie to pole
    private Company company; // przechowuje obiekt dostępu Company, musimy napisać jak w tym obiekcie nazywa się
                                // pole przechowujące dane companyDetails
                                    // w przypadku połączenia dwukierunkowego musimy określić w obu obiektach CascadeType

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public CompanyDetail() {
    }

    public CompanyDetail(String residence, Integer employeeNumber) {
        this.residence = residence;
        this.employeeNumber = employeeNumber;
    }

    public Integer getIdCompanyDetail() {
        return idCompanyDetail;
    }

    public void setIdCompanyDetail(Integer idCompanyDetail) {
        this.idCompanyDetail = idCompanyDetail;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public String toString() {
        return "CompanyDetail{" +
                "idCompanyDetail=" + idCompanyDetail +
                ", residence='" + residence + '\'' +
                ", employeeNumber=" + employeeNumber +
                '}';
    }
}
