package com.tb.util;

import java.util.List;

/**
 *
 * @author Velz
 */
public interface DaoService<E> {

    int addData(E object);

    int updateData(E object);

    int deleteData(E object);

    List<E> showAllData();
}
