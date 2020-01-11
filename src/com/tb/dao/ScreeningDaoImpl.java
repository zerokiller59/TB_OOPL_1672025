package com.tb.dao;

import com.tb.entity.Film;
import com.tb.entity.Screening;
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
public class ScreeningDaoImpl implements DaoService<Screening> {

    @Override
    public int addData(Screening object) {
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
    public int updateData(Screening object) {
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
    public int deleteData(Screening object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Screening> showAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Screening> screenings = session.createCriteria(Screening.class)
                .setFetchMode("film", FetchMode.JOIN)
                .setFetchMode("age_rating", FetchMode.JOIN)
                .list();
        session.close();
        return screenings;
    }

    public int validTiming(Screening object) {
        int result = 1;

        return result;
    }

}
