package com.tb.dao;

import com.tb.entity.AgeRating;
import com.tb.entity.Studio;
import com.tb.util.DaoService;
import com.tb.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Velz
 */
public class RatingDaoImpl implements DaoService<AgeRating> {

    @Override
    public int addData(AgeRating object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateData(AgeRating object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteData(AgeRating object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AgeRating> showAllData() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<AgeRating> ratings = session.createCriteria(AgeRating.class)
                .list();
        session.close();
        return ratings;
    }

}
