import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.Entity.Company;
import pl.strefakursow.Entity.CompanyDetail;

public class OneToOneApp {

    public static void main(String[] args) {
        // stworzyc obiekt Configuration
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");

        // wczytanie adnotacji
        conf.addAnnotatedClass(Company.class);
        conf.addAnnotatedClass(CompanyDetail.class);

        // stworzenie obiektu SessionFactory
        SessionFactory factory = conf.buildSessionFactory();

        // pobranie sesji
        Session session = factory.getCurrentSession();

        // wczytujemy
        session = factory.getCurrentSession();

        Company company = new Company("Strefakursow", 1000000);
        CompanyDetail detail = new CompanyDetail("Poland",150);
        company.setCompanyDetail(detail);


        session.beginTransaction();

        session.save(detail);
        session.save(company);


        session.getTransaction().commit();

        factory.close();

    }

}