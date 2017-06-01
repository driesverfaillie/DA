/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucll.da_domain;

import java.util.Collection;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author Dries
 */
@RequestScoped
@Named
@Default
public class MainService {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public MainService(){
        emf = Persistence.createEntityManagerFactory("placeDB");
      
        em = emf.createEntityManager();
    }
    
    
    @Transactional
    public void addConcert(String artist, Place place, String date){
        
        Concert concert = new Concert();
        concert.setArtist(artist);
        concert.setPlace(place);
        concert.setDate(date);
        
        
        try{
        
         em.persist( concert );
         em.flush();
         em.getTransaction( ).commit( );
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        finally{
         em.close( );
        
        }
       
    }
    
    @Transactional
    public Concert getConcert(Long id){
        
        
        Concert concert  = em.find(Concert.class, id);
        return  concert;
    }
    
    @Transactional
    public Collection<Concert> getAllConcerts(){
        Query query = em.createQuery("SELECT e FROM Concert e");
       return (Collection<Concert>) query.getResultList();
        
    }
    
    
}
