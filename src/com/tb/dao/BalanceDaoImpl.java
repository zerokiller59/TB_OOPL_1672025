package com.tb.dao;

import com.tb.entity.BalanceHistory;
import com.tb.entity.Film;
import com.tb.entity.User;
import com.tb.util.DaoService;
import com.tb.util.HibernateUtil;
import com.tb.util.ViewUtil;
import java.util.List;
import javafx.scene.control.Alert;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Velz
 */
public class BalanceDaoImpl implements DaoService<BalanceHistory> {

    @Override
    public int addData(BalanceHistory object) {
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
    public int updateData(BalanceHistory object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteData(BalanceHistory object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BalanceHistory> showAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<BalanceHistory> showTransactionBy(User object) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(BalanceHistory.class);
        Criterion userId = Restrictions.eq("user", object);
        List<BalanceHistory> u = cr.add(userId).list();
        return u;
    }

    public double countUserBalance(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<BalanceHistory> balances = session.createCriteria(BalanceHistory.class)
                .list();
        session.close();
        double balance = 0;
        for (BalanceHistory i : balances) {
            if (i.getUser().getId() == user.getId()) {
                if (i.isIsTopup()) {
                    balance += i.getValue();
                } else {
                    balance -= i.getValue();
                }
            }
        }
        return balance;
    }

}
