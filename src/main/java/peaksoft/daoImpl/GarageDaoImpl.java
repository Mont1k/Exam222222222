package peaksoft.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.w3c.dom.css.CSSStyleSheet;
import peaksoft.dao.GarageDao;
import peaksoft.model.Garage;
import peaksoft.util.Util;

public class GarageDaoImpl implements GarageDao {
    SessionFactory sessionFactory = Util.getSessionFactory();
    @Override
    public void createTables() {
        try(Session session = sessionFactory.openSession()){
        session.beginTransaction();
        session.createSQLQuery("create table if not exists Garage(" +
                "id serial primary key," +
                "name varchar not null," +
                "isEmpty varchar not null)").executeUpdate();
        session.getTransaction().commit();
    }

    }

    @Override
    public void deleteById(Long id) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Garage garage = session.get(Garage.class,id);
            session.remove(garage);
            session.getTransaction().commit();
        }

    }

    @Override
    public void saveGarage(Garage garage) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(garage);
            session.getTransaction().commit();
        }
    }
}
