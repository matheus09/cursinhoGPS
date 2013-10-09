/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Anderson
 */
public class EMF {
    
    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("CursinhoGPSPU");
    
    public static EntityManagerFactory getEntityManagerFactory(){
        return factory;
    }
    
}
