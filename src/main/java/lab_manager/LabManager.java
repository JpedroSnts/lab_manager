package lab_manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LabManager {
	public static void main(String[] args) {
		EntityManagerFactory ef = Persistence.createEntityManagerFactory("lab-manager");
		EntityManager em = ef.createEntityManager();
	}
}
