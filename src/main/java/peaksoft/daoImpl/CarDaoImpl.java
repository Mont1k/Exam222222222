package peaksoft.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.dao.CarDao;
import peaksoft.model.Car;
import peaksoft.model.Company;
import peaksoft.util.Util;

public class CarDaoImpl implements CarDao {
    SessionFactory sessionFactory = Util.getSessionFactory();
    @Override
    public void createTables() {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.createSQLQuery("create table if not exists Car(" +
                    "id serial primary key," +
                    "mark varchar not null," +
                    "producedCountry varchar not null)").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Car car = session.get(Car.class,id);
            session.remove(car);
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveCar(Car car) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(car);
            session.getTransaction().commit();
        }
    }
}
