package facades;

import dtos.FitnessCenter.FitnessCenterDTO;
import dtos.FitnessCenter.FitnessCentersDTO;
import entities.FitnessCenter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
import java.util.List;

public class FitnessCenterFacade {
    private static EntityManagerFactory emf;
    private static FitnessCenterFacade instance;

    private FitnessCenterFacade () {

    }

    public static FitnessCenterFacade getFitnessCenterFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FitnessCenterFacade();
        }
        return instance;
    }

    public FitnessCenterDTO addFitnessCenter (FitnessCenterDTO fitnessCenterDTO) {
        EntityManager em = emf.createEntityManager();
        try {
            FitnessCenter fitnessCenter = new FitnessCenter(fitnessCenterDTO.getName(),fitnessCenterDTO.getCity(),fitnessCenterDTO.getPricePrMonth());
            em.getTransaction().begin();
            em.persist(fitnessCenter);
            em.getTransaction().commit();
            return new FitnessCenterDTO(fitnessCenter);
        } finally {
            em.close();
        }
    }

    public FitnessCentersDTO getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<FitnessCenter> query = em.createQuery("SELECT f from FitnessCenter f", FitnessCenter.class);
            List<FitnessCenter> result = query.getResultList();
            FitnessCentersDTO fitnessCentersDTO = new FitnessCentersDTO(result);
            em.getTransaction().commit();
            return fitnessCentersDTO;
        } finally {
            em.close();
        }
    }

    public FitnessCenterDTO editFitnessCenter (FitnessCenterDTO fitnessCenterDTO) {
        EntityManager em = emf.createEntityManager();
        try {
            FitnessCenter fitnessCenter = em.find(FitnessCenter.class, fitnessCenterDTO.getId());
            fitnessCenter.setName(fitnessCenterDTO.getName());

            em.getTransaction().begin();
            em.merge(fitnessCenter);
            em.getTransaction().commit();

            return new FitnessCenterDTO(fitnessCenter);
        }finally {
            em.close();
        }
    }

    public FitnessCenterDTO deleteFitnessCenter (int id) throws WebApplicationException {
        EntityManager em = emf.createEntityManager();
        FitnessCenter fitnessCenter = em.find(FitnessCenter.class, id);
        if (fitnessCenter == null) {
            throw new WebApplicationException("There is no fitnesscenter matching the id");
        } else {
            try {
                return null;
            } finally {
                em.close();
            }
        }
    }

    public FitnessCenterDTO getById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            FitnessCenter fitnessCenter = em.find(FitnessCenter.class, id);
            return new FitnessCenterDTO(fitnessCenter);
        } finally {
            em.close();
        }
    }

    }






