package org.example;

import org.example.entity.WorkerAza;
import org.example.util.Hibernate;

import org.hibernate.Session;
import org.hibernate.query.Query;


import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        WorkerAza worker1 = new WorkerAza("Aza","Aliev",23);
        WorkerAza worker2 = new WorkerAza("Aza","Aliev",19);
        WorkerAza worker3 = new WorkerAza("Aza","Aliev",28);
        WorkerAza worker4 = new WorkerAza("Aza","Aliev",29);
        WorkerAza worker5 = new WorkerAza("Aza","Aliev",17);

        create(worker1);
        create(worker2);
        create(worker3);
        create(worker4);
        create(worker5);

    }

    public static int create(WorkerAza worker) {


        Session session = Hibernate.getSession().openSession();
        session.beginTransaction();
        session.save(worker);

        session.getTransaction().commit();
        session.close();
        System.out.println("Added sucessfully" + worker);
        return worker.getId();

    }

    public static List<WorkerAza> getByAza(String name, int age){


        Session session = Hibernate.getSession().openSession();
        session.beginTransaction();
        List<WorkerAza> workerAzas = session.createQuery("FROM WorkerAza  e WHERE e.name =: name and e.age>:age ").
                setParameter("name",name).setParameter("age",age).getResultList();
        session.getTransaction().commit();
        session.close();
        return workerAzas;
    }

    public static void ChangeAge(String name, int age){


        Session session=Hibernate.getSession().openSession();
        session.beginTransaction();
        Query query = (Query) session.createQuery("UPDATE WorkerAza set age =:age WHERE name=:name")
                .setParameter("name",name).setParameter("age",age);
        System.out.println("UPDATE"+name + " " + age);

        query.executeUpdate();
        session.beginTransaction().commit();
        session.close();
        System.out.println(name + "delete");

    }
    public static void deleteByName(String name){
        Session session = Hibernate.getSession().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete FROM WorkerAza WHERE name=:name").setParameter("name",name);
        query.executeUpdate();
        session.beginTransaction().commit();
        session.close();
        System.out.println(name+"delet");
    }




}
