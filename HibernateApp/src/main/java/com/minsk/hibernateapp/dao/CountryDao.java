/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.minsk.hibernateapp.dao;

import com.minsk.hibernateapp.entity.City;
import com.minsk.hibernateapp.entity.Country;
import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import com.minsk.hibernateapp.utils.HibernateSessionFactoryUtil;

public class CountryDao implements CountryDaoInterface<Country, String> {

  private Session currentSession;
     
    private Transaction currentTransaction;

    public CountryDao() {
    }
    
   public Session openCurrentSession() {
        currentSession = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return currentSession;
    }
 
    public Session openCurrentSessionwithTransaction() {
        currentSession = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
     
    public void closeCurrentSession() {
        currentSession.close();
    }
     
    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }
 
    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }
 
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }
 
    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }
 
    public void persist(Country entity) {
        getCurrentSession().save(entity);
    }
 
    public void update(Country entity) {
        getCurrentSession().update(entity);
    }
 
    public Country findById(String id) {
        Country country = (Country) getCurrentSession().get(Country.class, id);
        return country; 
    }
 
    public void delete(Country entity) {
        getCurrentSession().delete(entity);
    }
 
    @SuppressWarnings("unchecked")
    public List<Country> findAll() {
        List<Country> countries = (List<Country>) getCurrentSession().createQuery("from Country").list();
        return countries;
    }
 
    public void deleteAll() {
        List<Country> entityList = findAll();
        for (Country entity : entityList) {
            delete(entity);
        }
    }
    
}    
