package me.zhukov.homelibrary.hibernate.work;

import org.hibernate.Session;

/**
 * @author Michael Zhukov
 */
public interface Work {

    void doWork(Session session);
}
