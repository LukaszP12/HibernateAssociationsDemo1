import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.entity.Company;
import pl.strefakursow.entity.CompanyDetail;
import pl.strefakursow.entity.Property;

import java.util.List;

public class OneToManyDeleteApp {


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

        System.out.println(company);

        for ( Property property : company.getProperties()){
            if ("Gdynia".equals(property.getCity())){
                currentSession.delete(property);
            }
        }

        for (Property property : company.getProperties()){
            if ("Warszawa".equals(property.getCity())){
                currentSession.delete(property);
            }
        }

        currentSession.getTransaction().commit();

        currentSession.close();

    }




}
