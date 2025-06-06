package dao;

import jakarta.persistence.*;
import java.util.List;
import entidades.Genero;

public class GeneroDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SemanaWeb");

    public List<Genero> listarGeneros() {
        EntityManager em = emf.createEntityManager();
        List<Genero> lista = em.createQuery("SELECT g FROM Genero g", Genero.class).getResultList();
        em.close();
        return lista;
    }

    public void registrarGenero(Genero genero) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(genero);
        em.getTransaction().commit();
        em.close();
    }

    
    public Genero buscarPorNombre(String nombre) {
        EntityManager em = emf.createEntityManager();
        Genero genero = null;
        try {
            genero = em.createQuery("SELECT g FROM Genero g WHERE g.nombre = :nombre", Genero.class)
                       .setParameter("nombre", nombre)
                       .getSingleResult();
        } catch (NoResultException e) {
            
        } finally {
            em.close();
        }
        return genero;
    }
}