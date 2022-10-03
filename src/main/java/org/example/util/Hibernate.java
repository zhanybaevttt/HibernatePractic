package org.example.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {

    private static final SessionFactory session = buildSession();

    private static SessionFactory buildSession(){
       try {
           return new Configuration().configure("hubernate.cfg.xml.tml").buildSessionFactory();
       }catch (Throwable e){
           throw new ExceptionInInitializerError(e);
       }
    }
public static SessionFactory getSession(){
        return session;
}

}

