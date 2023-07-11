package com;

import java.util.Scanner;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {

	 

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        Customer c = new Customer();

        Scanner sc = new Scanner(System.in);

        System.out.print("Id: ");
        int cid = sc.nextInt();
        System.out.print("Name: ");
        String cname = sc.next();
        System.out.print("Place: ");
        String place = sc.next();
        System.out.print("PAN: ");
        String pan = sc.next();

        c.setCid(cid);
        c.setCname(cname);
        c.setPlace(place);
        c.setPan(pan);

        session.save(c);
        t.commit();

        System.out.println("Data inserted successfully");
    }

 

}
