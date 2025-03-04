package es.upgrade.prueba;

import es.upgrade.entidad.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class _01_InsertPersona {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba");
        EntityManager em = emf.createEntityManager();

        Persona persona = new Persona();
        persona.setNombre("Piero");
        persona.setPeso(65.5);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(persona);
        tx.commit();
        em.close();

        System.out.println(persona);
    }
}
