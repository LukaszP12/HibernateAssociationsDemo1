import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.entity.Company;
import pl.strefakursow.entity.CompanyDetail;
import pl.strefakursow.entity.Property;

import java.util.List;

public class ManyToManyHQLApp {

    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(CompanyDetail.class);
        configuration.addAnnotatedClass(Property.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        String getCompany = "select c.name from Property p join p.company c where p.city='Sevilla'";

        String getCompanyZurich = "select c.name from Property p join p.company c where p.city='Zurich'";

        String getCompany2 = "select c.name from Property p join p.company c join c.companyDetail cd where p.city='Barcelona' and cd.residence='Switzerland' ";

        // Swiss company with property in Zurich
        String getCompany3 = "select c.name from Property p join p.company c join c.companyDetail cd where p.city='Zurich' and cd.residence='Switzerland' ";

        currentSession.getTransaction().begin();
        Query query = currentSession.createQuery(getCompany);
        Query query1 = currentSession.createQuery(getCompanyZurich);
        Query query2 = currentSession.createQuery(getCompany2);
        Query query3 = currentSession.createQuery(getCompany3);

        List<String> resultList = query.getResultList();
        List<String> resultList1 = query1.getResultList();
        List<String> resultList2 = query2.getResultList();
        List<String> resultList3 = query3.getResultList();

        currentSession.getTransaction().commit();

        System.out.println("Companies based in Sevilla");
        for (String name : resultList){
            System.out.println(name);
        }

        System.out.println("Companies based in Zurich");
        for (String name1 : resultList1){
            System.out.println(name1);
        }

        System.out.println("Swiss company with property in Barcelona");
        for (String name2 : resultList2){
            System.out.println(name2);
        }

        System.out.println("Swiss company with property in Zurich");
        for (String name : resultList3){
            System.out.println(name);
        }

        currentSession.close();
    }

}
