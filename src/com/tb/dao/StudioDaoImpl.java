package com.tb.dao;

import com.tb.entity.Film;
import com.tb.entity.Studio;
import com.tb.util.DaoService;
import com.tb.util.HibernateUtil;
import com.tb.util.ViewUtil;
import java.math.BigInteger;
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
public class StudioDaoImpl implements DaoService<Studio> {

    @Override
    public int addData(Studio object) {
        int result = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(object);
            transaction.commit();
//            Long lastId = ((BigInteger) session.createSQLQuery("SELECT LAST_INSERT_ID()").uniqueResult()).longValue();
//            result = Math.toIntExact(lastId);
        } catch (HibernateException e) {
            transaction.rollback();
            result = 0;
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
        return result;
    }

    @Override
    public int updateData(Studio object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteData(Studio object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Studio> showAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Studio> studios = session.createCriteria(Studio.class)
                .list();
        session.close();
        return studios;
    }

//    public int addSeatsToStudio(Seat object) {
//        int result = 1;
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        try {
//            session.save(object);
//            transaction.commit();
//        } catch (HibernateException e) {
//            transaction.rollback();
//            result = 0;
//            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
//        }
//        return result;
//    }
}
