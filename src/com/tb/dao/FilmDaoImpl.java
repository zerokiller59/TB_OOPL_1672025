package com.tb.dao;

import com.tb.entity.AgeRating;
import com.tb.entity.Film;
import com.tb.util.DaoService;
import com.tb.util.HibernateUtil;
import com.tb.util.ViewUtil;
import java.util.List;
import javafx.scene.control.Alert;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Velz
 */
public class FilmDaoImpl implements DaoService<Film> {

    @Override
    public int addData(Film object) {
        int result = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            result = 0;
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
        return result;
    }

    @Override
    public int updateData(Film object) {
        int result = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(object);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            result = 0;
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
        return result;
    }

    @Override
    public int deleteData(Film object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Film> showAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Film> films = session.createCriteria(Film.class)
                .setFetchMode("age_rating", FetchMode.JOIN)
                .list();
        session.close();
        return films;
    }

//    public List<AgeRating> showRatings() {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        List<AgeRating> ratings = session.createCriteria(AgeRating.class)
//                .list();
//        session.close();
//        return ratings;
//    }
}
