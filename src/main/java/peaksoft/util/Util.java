package peaksoft.util;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.model.*;
import java.util.Properties;
public class Util {
    public static SessionFactory getSessionFactory(){
        Properties properties = new Properties();
        properties.put(Environment.DRIVER, "org.postgresql.Driver");
        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.put(Environment.USER, "postgres");
        properties.put(Environment.PASS, "nurtohun22");
        properties.put(Environment.HBM2DDL_AUTO, "create");
        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
        properties.put(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Car.class);
        configuration.addAnnotatedClass(Company.class);
        configuration.addAnnotatedClass(Garage.class);
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(SocialMedia.class);

        return configuration.buildSessionFactory();
    }
}
