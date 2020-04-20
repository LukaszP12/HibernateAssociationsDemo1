import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.strefakursow.entity.Company;
import pl.strefakursow.entity.CompanyDetail;

public class CascadeRemoveApp {



    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(CompanyDetail.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.beginTransaction();

        Company company = currentSession.get(Company.class, 48);
        currentSession.remove(company);

        // currentSession.refresh(); refresh() causes the data from DataBase to be read again into the object
        // currentSession.detach(); if we detach the parent object from the session, then the child object also gets detached
        // currentSession.merge(); if we add the parent object to the session, then the child object also gets merged

        currentSession.getTransaction().commit();

        sessionFactory.close();

    }
}
