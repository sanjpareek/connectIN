package com.connectin;

import com.connectin.models.Users;
import org.hibernate.Session;
import  org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 * Created by sanjana on 23/7/17.
 */
public class DBServices {
   static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
   static Session session = sessionFactory.openSession();

        public static void insertRecord(String userId, String firstName, String lastName, String email){
            Transaction transaction = session.beginTransaction();
            Users user = new Users();
            user.setUserId(userId);
            user.setLastName(lastName);
            user.setFirstName(firstName);
            user.setEmail(email);
            session.save(user);
            session.getTransaction().commit();
            transaction.commit();
        }

        public static Users getUser(String userId){

            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("from Users where userId= :userId");
            query.setParameter("userId" , userId);
            Users users = (Users)query.uniqueResult();
            transaction.commit();
            return users;

        }

}
