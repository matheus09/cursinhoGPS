/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Hyago Brendoll
 */
public class JPAUtil {
    public final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("cursinhoGPSPU");   
}
