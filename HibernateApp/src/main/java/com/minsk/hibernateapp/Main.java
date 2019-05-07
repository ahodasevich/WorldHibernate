/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minsk.hibernateapp;

import com.minsk.hibernateapp.entity.City;
import com.minsk.hibernateapp.services.CityService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Main {
    public static void main(String[] args) {
      /*  City c1 = new City(1, "Minsk", "Minsk", "m", 100);
        City c4 = new City(1, "Minsk", "Minsk", "m", 100);
        City c2 = new City(1, "Min", "Min", "m", 200);
    //hello
        System.out.println(c1.hashCode());
                System.out.println(c2.hashCode());
                  System.out.println(c4.hashCode());
                                   
                  */
       /*
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(City.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
 Session session = sessionFactory.openSession();
        String queryString = "from City where countrycode= :value ";
        Query queryObject = session.createQuery(queryString);
        queryObject.setParameter("value", "gbr");
        List<City> list = queryObject.list();
         for (City l: list){
             System.out.println(l);
         }
            } catch (Exception e) {
                System.out.println("Exception!" + e);
            }
        */
       
       CityService cityService = new CityService();
      // City city1 = new City (4081, "Zhodino", "BLR", "Minskaya", 30000);
      City city1 = cityService.findById(4081);
 city1.setPopulation(6000);
       cityService.update(city1);
      
      //  cityService.delete(4080);
      
      //  System.out.println(cityService.findById(999));
     
       
       
       List<City> list = cityService.findAll();
       for (City l: list){
             System.out.println(l);
         } 
    }
    
}
