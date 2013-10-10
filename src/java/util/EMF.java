package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * UFRN - GESTÃO DE PROJETOS
 * @author Monnalisa Christina
 * data: 10.10.2013
 */
public class EMF {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursinhoGPSPU");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}