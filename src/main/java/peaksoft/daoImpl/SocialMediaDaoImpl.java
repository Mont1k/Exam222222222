package peaksoft.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import peaksoft.dao.SocialMediaDao;
import peaksoft.model.Company;
import peaksoft.model.SocialMedia;
import peaksoft.util.Util;

public class SocialMediaDaoImpl implements SocialMediaDao {
    SessionFactory sessionFactory = Util.getSessionFactory();
    @Override
    public void createTables() {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.createSQLQuery("create table if not exists SocialMedia(" +
                    "id serial primary key," +
                    "SocialMedia varchar unique not null)").executeUpdate();
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Long id) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            SocialMedia socialMedia = session.get(SocialMedia.class,id);
            session.remove(socialMedia);
            session.getTransaction().commit();
        }
    }

    @Override
    public void saveSocialMedia(SocialMedia socialMedia) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(socialMedia);
            session.getTransaction().commit();
        }
    }
}
