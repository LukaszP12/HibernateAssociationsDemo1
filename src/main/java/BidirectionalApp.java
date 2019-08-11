import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.Entity.Company;
import pl.strefakursow.Entity.CompanyDetail;

public class BidirectionalApp {

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


        // Company company = new Company("KGHM", 1000000);
        Company company = new Company("Orlen",2000000);
        CompanyDetail detail = new CompanyDetail("Poland",15000);
        detail.setCompany(company);
        company.setCompanyDetail(detail);


        session.beginTransaction();

     //   session.persist(detail);
        session.getTransaction().commit();

        CompanyDetail detail2 = session.get(CompanyDetail.class, 12); // chcemy utworzyć połączenie dwukierunkowe

        session.getTransaction().commit();

        System.out.println(detail.getCompany());

        factory.close();


    }

}
