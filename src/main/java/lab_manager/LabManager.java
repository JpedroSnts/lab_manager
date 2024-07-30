package lab_manager;

import lab_manager.util.LabManagerEntityManager;

import javax.persistence.EntityManager;

public class LabManager {
	public static void main(String[] args) {
		EntityManager em = LabManagerEntityManager.Factory.createEntityManager();
	}
}
