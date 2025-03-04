package es.upgrade.prueba;

import es.upgrade.modelo.entidad.Cliente;
import es.upgrade.modelo.entidad.Direccion;
import es.upgrade.modelo.entidad.Pedido;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class _01_PruebaCliente {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("prueba");
        EntityManager em = emf.createEntityManager();

        Cliente cliente = new Cliente(null, "Piero", "681618066", null, null);

        Direccion direccion = new Direccion();
        direccion.setNombreVia("Ayerbe");
        direccion.setTipoVia("Calle");
        direccion.setCiudad("Madrid");

        cliente.setDireccion(direccion);

        List<Pedido> pedidos = new ArrayList<>();
        Pedido p1 = new Pedido(null,"PED-1",new Date(),cliente);
        Pedido p2 = new Pedido(null,"PED-2",new Date(),cliente);
        Pedido p3 = new Pedido(null,"PED-3",new Date(),cliente);
        Pedido p4 = new Pedido(null,"PED-4",new Date(),cliente);
        Pedido p5 = new Pedido(null,"PED-5",new Date(),cliente);
        pedidos.add(p1);
        pedidos.add(p2);
        pedidos.add(p3);
        pedidos.add(p4);
        pedidos.add(p5);

        cliente.setListPedidos(pedidos);



        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(cliente);
        et.commit();

        System.out.println(cliente);
        em.close();





    }
}
