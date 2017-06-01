/*/
/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucll.da_domain;

/**
 *
 * @author Dries
 */
public class test {
    
    public static void main(String[] args){ 
    
        
        Place place = new Place();
        place.setCity("testCity");
        place.setCountry("Belgium");
        place.setName("testName");
        MainService serv = new MainService();
        
        serv.addConcert("testartist", place, "19/06/2017");
        // System.out.println(serv.getAllConcerts());
    }
    
}
