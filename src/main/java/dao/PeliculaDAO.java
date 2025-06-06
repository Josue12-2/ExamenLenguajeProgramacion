package dao;

import jakarta.persistence.*;
import java.util.List;

import entidades.Genero;
import entidades.Pelicula;

public class PeliculaDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SemanaWeb");

    public void registrar(Pelicula pelicula) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(pelicula);
        em.getTransaction().commit();
        em.close();
    }

    public List<Pelicula> listar() {
        EntityManager em = emf.createEntityManager();
        List<Pelicula> lista = em.createQuery("SELECT p FROM Pelicula p", Pelicula.class).getResultList();
        em.close();
        return lista;
    }

    public List<Genero> listarGeneros() {
        EntityManager em = emf.createEntityManager();
        List<Genero> lista = em.createQuery("SELECT g FROM Genero g", Genero.class).getResultList();
        em.close();
        return lista;
    }
}
