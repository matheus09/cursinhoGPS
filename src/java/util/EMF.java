package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author ciro
 */
public class EMF {
    // "cursinhoGPSPU" deve ser substituído por "SeuProjetoPU"
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursinhoGPSPU");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
