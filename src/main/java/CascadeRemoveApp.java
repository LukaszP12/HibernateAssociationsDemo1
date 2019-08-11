import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.Entity.Company;
import pl.strefakursow.Entity.CompanyDetail;

public class CascadeRemoveApp {

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

        session.beginTransaction();

        Company company = session.get(Company.class, 16);
        // usuwamy obiekt company z bazy danych
        session.remove(company);
        // session.refresh(company);  odświeżenie danego obiektu - powoduje też odświeżenie obiektu z nim powiązanego

        session.getTransaction().commit();

        factory.close();
    }

}
