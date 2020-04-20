import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.entity.Company;
import pl.strefakursow.entity.CompanyDetail;
import pl.strefakursow.entity.Property;

import java.util.List;

public class OneToManySaveApp {


    public static void main(String[] args) {

        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(CompanyDetail.class);
        configuration.addAnnotatedClass(Property.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        String getCompany = "select c from Company c where c.name='Strefakursow' ";


        currentSession.getTransaction().begin();

        Query query = currentSession.createQuery(getCompany);
        Company company = (Company) query.getSingleResult();

        System.out.println(company.getName() + "company details: " + company.getCompanyDetail() + " ");

        Property property = new Property("Warszawa",40);
        Property property1 = new Property("Gdynia",30);

        company.addProperty(property);
        company.addProperty(property1);

        currentSession.persist(property);
        currentSession.persist(property1);

        currentSession.getTransaction().commit();

        currentSession.close();

    }
}