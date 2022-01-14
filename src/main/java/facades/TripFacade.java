package facades;

import dtos.FitnessCenter.FitnessCentersDTO;
import dtos.GuideDTO;
import dtos.TripsDTO;
import entities.FitnessCenter;
import entities.Guide;
import entities.Trip;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class TripFacade {

    private static EntityManagerFactory emf;
    private static TripFacade instance;

    public TripFacade() {
    }

    public static TripFacade getTripFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new TripFacade();
        }
        return instance;
    }

    public static TripFacade getUserFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new TripFacade();
        }
        return instance;
    }


    public TripsDTO getAllTrips(){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Trip> query = em.createQuery("SELECT t from Trip t", Trip.class);
            List<Trip> result = query.getResultList();
            TripsDTO tripsDTO = new TripsDTO(result);
            em.getTransaction().commit();
            return tripsDTO;
        } finally {
            em.close();
        }
    }

    //create trips kig harbour opgave create boat
    public Trip createTrip (Trip trip) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            trip.setName(trip.getName());
            trip.setDate(trip.getDate());
            trip.setTime(trip.getTime());
            trip.setLocation(trip.getLocation());
            trip.setDuration(trip.getDuration());
            trip.setPackingList(trip.getPackingList());

            em.persist(trip);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return trip;
    }

    public GuideDTO getAllGuides() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Guide> query = em.createNamedQuery("Guide.getAllRows", Guide.class);
            List<Guide> result = query.getResultList();
            GuideDTO dto = new GuideDTO((Guide) result);
            em.getTransaction().commit();
            return dto;
        }  finally {
            em.close();
        }
    }

    public Guide createGuide (Guide guide) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            guide.setName(guide.getName());
            guide.setGender(guide.getGender());

            em.persist(guide);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        return guide;
    }

    // lav en addUserToTrip

    public Trip addUserToTrip (Long id, String userName) {
        EntityManager em = emf.createEntityManager();
        Trip trip = em.find(Trip.class,id);
        User user = em.find(User.class,userName);
        trip.addUser(user);
        return trip;
    }

}




