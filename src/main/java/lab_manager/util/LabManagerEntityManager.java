package lab_manager.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LabManagerEntityManager {
    public static final EntityManagerFactory Factory = Persistence.createEntityManagerFactory("lab-manager");
}
