/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author daniel
 */
public class EMF {
    private static EntityManagerFactory factory;
    
    public static EntityManagerFactory getFactory()
    {
        if(factory == null){
            factory = Persistence.createEntityManagerFactory("cursinhoGPSPU");
        }
        return factory;
    }
}
