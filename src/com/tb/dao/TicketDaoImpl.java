package com.tb.dao;

import com.tb.entity.Screening;
import com.tb.entity.Ticket;
import com.tb.util.DaoService;
import com.tb.util.HibernateUtil;
import com.tb.util.ViewUtil;
import java.math.BigInteger;
import java.util.List;
import javafx.scene.control.Alert;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Velz
 */
public class TicketDaoImpl implements DaoService<Ticket> {

    @Override
    public int addData(Ticket object) {
        int result;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(object);
            result = object.getId();
            if (!transaction.wasCommitted()) {
                transaction.commit();
            }
        } catch (HibernateException e) {
            transaction.rollback();
            result = 0;
            ViewUtil.showAlert(Alert.AlertType.ERROR, "Error", e.getMessage());
        }
        return result;
    }

    @Override
    public int updateData(Ticket object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteData(Ticket object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ticket> showAllData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int countBoughtSeats(Screening screening) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Ticket.class);
        cr.add(Restrictions.eq("screening", screening));
        return cr.list().size();
    }
}
