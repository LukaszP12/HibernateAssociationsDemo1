import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.entity.Company;
import pl.strefakursow.entity.CompanyDetail;

public class BiDirectionalApp {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(CompanyDetail.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();


    //    Company company = new Company("PZU",100000);
    //    CompanyDetail companyDetail = new CompanyDetail("Poland",17000);
    //    companyDetail.setCompany(company);
    //    company.setCompanyDetail(companyDetail);

        currentSession.beginTransaction();

    //    currentSession.persist(companyDetail);
        CompanyDetail companyDetail = currentSession.get(CompanyDetail.class, 44);
        currentSession.remove(companyDetail);

        currentSession.getTransaction().commit();

    //    System.out.println(companyDetail.getCompany());

        currentSession.close();

    }

}
