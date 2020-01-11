package com.tb.dao;

import com.tb.entity.Film;
import com.tb.entity.User;
import com.tb.util.DaoService;
import com.tb.util.HibernateUtil;
import com.tb.util.TextUtil;
import com.tb.util.ViewUtil;
import java.util.List;
import javafx.scene.control.Alert;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Velz
 */
public class UserDaoImpl implements DaoService<User> {

    @Override
    public int addData(User object) {
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
    public int updateData(User object) {
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
    public int deleteData(User object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> showAllData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> user = session.createCriteria(User.class)
                .list();
        session.close();
        return user;
    }

    public User login(User object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(User.class);
        Criterion username = Restrictions.eq("username", object.getUsername());
        Criterion password = Restrictions.eq("password", object.getPassword());
        LogicalExpression andExp = Restrictions.and(username, password);
        List<User> u = cr.add(andExp).setFetchMode("role", FetchMode.JOIN).list();
        if (u.size() != 0) {
            return u.get(0);
        } else {
            return new User();
        }
    }

}
