import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.entity.Company;
import pl.strefakursow.entity.CompanyDetail;

public class OneToOneApp {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(CompanyDetail.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        Company company = new Company("Strefakursow",1000000);
        CompanyDetail companyDetail = new CompanyDetail("Poland",150);
        company.setCompanyDetail(companyDetail);

        currentSession.beginTransaction();

        currentSession.save(companyDetail);
        currentSession.save(company);

        currentSession.getTransaction().commit();

        currentSession.close();

    }

}
