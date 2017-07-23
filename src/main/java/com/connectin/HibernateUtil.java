package com.connectin;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

/**
 * Created by sanjana on 23/7/17.
 */
public class HibernateUtil {

        private static final SessionFactory sessionFactory = buildSessionFactory();

        private static SessionFactory buildSessionFactory()
        {
            try
            {
                // Create the SessionFactory from hibernate.cfg.xml
                return new Configuration().configure().buildSessionFactory();
            }
            catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }

        public static SessionFactory getSessionFactory() {
            return sessionFactory;
        }

        public static void shutdown() {
            // Close caches and connection pools
            getSessionFactory().close();
        }
    }