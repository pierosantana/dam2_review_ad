package es.upgrade.prueba;

import es.upgrade.entidad.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class _03_FindPersona {
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

        //No es necesario abrir Transaction si solo vamos a consultar sin cambiar nada.
        Persona persona3 = em.find(Persona.class, 2);

        System.out.println(persona3);
        em.close();



    }
}
