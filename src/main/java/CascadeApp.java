import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.entity.Company;
import pl.strefakursow.entity.CompanyDetail;

public class CascadeApp {




    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(CompanyDetail.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        Company company = new Company("KGHM",10000000);
        CompanyDetail companyDetail =  new CompanyDetail("Poland",15000);
        company.setCompanyDetail(companyDetail);

        currentSession.beginTransaction();
        currentSession.persist(company);

        currentSession.getTransaction().commit();

        sessionFactory.close();

    }

}
