import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.strefakursow.entity.Company;
import pl.strefakursow.entity.CompanyDetail;

import java.util.List;

public class OneToOneHQLApp {


    public static void main(String[] args) {
        Configuration configuration = new Configuration();

        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(CompanyDetail.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session currentSession = sessionFactory.getCurrentSession();

        String getAllCompanies = "Select c from Company c";
        String getAllCompaniesNames = "Select c.name from Company c";
        String getAllItalianCompanies = "Select c from Company c join c.companyDetail cd where cd.residence='Italy'";

        String getAllPolishCompanies = "Select c from Company c join c.companyDetail cd where cd.residence='Poland'";

        currentSession.getTransaction().begin();

        Query query = currentSession.createQuery(getAllCompanies);
        List<Company> resultListCompanies = query.getResultList();

        Query query1 = currentSession.createQuery(getAllCompaniesNames);
        List<String> resultListNames = query1.getResultList();

        Query query2 = currentSession.createQuery(getAllItalianCompanies);
        List<Company> resultListItalianCompanies = query2.getResultList();

        Query query3 = currentSession.createQuery(getAllPolishCompanies);
        List<Company> resultListPolishCompanies = query3.getResultList();

      /*  System.out.println("Commpanies names");
        for (String companyName : resultListNames){
            System.out.println(companyName);
        }

        System.out.println("Commpanies: ");
        for (Company company : resultListCompanies){
            System.out.println(company.toString());
        } */

/*        System.out.println("The following companies are based in Italy");

        for (Company company : resultListItalianCompanies){
            System.out.println(company.getName());
        } */

        System.out.println("The following companies are based in Poland");
        for (Company company : resultListPolishCompanies){
            System.out.println(company.getName());
        }

        currentSession.getTransaction().commit();

        currentSession.close();
    }

}
