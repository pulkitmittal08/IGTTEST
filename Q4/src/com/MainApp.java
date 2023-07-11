package com;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee e = (Employee)context.getBean("emp");

        System.out.println("Id: " + e.getId());
        System.out.println("Name: " + e.getName());

        System.out.print("Programming Languages: ");
        ArrayList<String> a = e.getProgramming();
        for(String l: a) {
            System.out.print(l + ", ");
        }

  }
}



