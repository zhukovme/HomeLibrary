package me.zhukov.homelibrary.hibernate.services;

import me.zhukov.homelibrary.hibernate.data.Book;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author Michael Zhukov
 */
public abstract class DBService {

    protected final SessionFactory sessionFactory;

    public DBService() {
        Configuration configuration = getConfiguration();
        sessionFactory = createSessionFactory(configuration);
    }

    protected Configuration getConfiguration() {
        Configuration configuration = new Configuration();
        configuration
                .addAnnotatedClass(Book.class)
                .configure("hibernate.cfg.xml");
        return configuration;
    }

    protected static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
