package de.htwsaar.prog3.carrental.dao;

import de.htwsaar.prog3.carrental.model.Rental;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * DAO implementation for the Rental model.
 *
 * @author Julian Quint, Arthur Kelsch
 */
public class RentalDaoImpl implements GenericDao<Rental, Long> {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public RentalDaoImpl() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("car-rental");
    }

    @Override
    public void persist(Rental entity) {
        entityManager.persist(entity);
    }

    @Override
    public Rental findById(Long id) {
        return entityManager.find(Rental.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Rental> findAll() {
        return (List<Rental>) entityManager.createQuery("SELECT e FROM Rental e").getResultList();
    }

    @Override
    public void update(Rental entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Rental entity) {
        entityManager.remove(entity);
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM Rental").executeUpdate();
    }

    @Override
    public void createEntityManager() {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void closeEntityManager() {
        entityManager.close();
    }

    @Override
    public void beginTransaction() {
        entityManager.getTransaction().begin();
    }

    @Override
    public void commitTransaction() {
        entityManager.getTransaction().commit();
    }
}
