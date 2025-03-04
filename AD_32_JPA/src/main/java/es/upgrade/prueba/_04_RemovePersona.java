package es.upgrade.prueba;

import es.upgrade.entidad.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class _04_RemovePersona {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba");
        EntityManager em = emf.createEntityManager();

        Persona persona = new Persona();
        persona.setNombre("Piero");
        persona.setPeso(65.5);

        Persona persona2 = new Persona();
        persona2.setNombre("Oscar");
        persona2.setPeso(75.5);

        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(persona);
        em.persist(persona2);
        et.commit();

        System.out.println(persona);
        System.out.println(persona2);

        et.begin();
        em.remove(persona);
        et.commit();

        //Listar todas las personas
        List<Persona> listPersonas = em.createQuery("from Persona p").getResultList();

        for (Persona p : listPersonas) {
            System.out.println(p);
        }

        em.close();

    }
}
