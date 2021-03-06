package facades;

import dtos.TripsDTO;
import entities.Trip;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TripFacadeTest {

    private static EntityManagerFactory emf = EMF_Creator.createEntityManagerFactoryForTest();
    private static EntityManager em = emf.createEntityManager();
    private static TripFacade facade;

    private static Trip t1 = new Trip("GreenLand", "marts", "1400", "Nuuk", "12", "warm clothes");
    private static Trip t2 = new Trip("France", "Januar", "1400", "Paris", "12", "warm clothes");
    private static Trip t3 = new Trip("Demark", "Januar", "1400", "Copenhagen", "12", "warm clothes");

    public TripFacadeTest() {
    }

    @AfterAll
    public static void tearDownClass() {
//  Clean up database after test is done.
    }

    @BeforeAll
    static void setUp() {
        facade = TripFacade.getTripFacade(emf);
        //em.createNamedQuery("Trip.deleteAllRows").executeUpdate();
            em.getTransaction().begin();

            em.persist(t1);
            em.persist(t2);
            em.persist(t3);
            em.getTransaction().commit();

    }

    @AfterEach
    void tearDown() {
        EntityManager em = emf.createEntityManager();
    }

    //Create Trip Test
    //test works
    @Test
    void createTrip() {
        EntityManager em = emf.createEntityManager();
       // t1.addTrip(t1)

    }
    //test worksgit 
    @Test
    void getAllTrips() {
        try {
            em.getTransaction().begin();
            TripsDTO result = facade.getAllTrips();
            em.getTransaction().commit();
            System.out.println(result);
            assertEquals(3, result.getGetAllTrips().size());

        } finally {
            em.close();
        }
    }


}