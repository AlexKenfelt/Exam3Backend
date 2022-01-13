package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.*;
import utils.EMF_Creator;

public class Populator {

    public static void populate() {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();

        MemberFacade mf = MemberFacade.getMemberFacade(emf);
        FitnessCenterFacade fcf = FitnessCenterFacade.getFitnessCenterFacade(emf);
        EntityManager em = emf.createEntityManager();

        UserFacade uf = UserFacade.getUserFacade(emf);
        TripFacade tf = TripFacade.getTripFacade(emf);

        Trip t1 = new Trip(1L, "GreenLand", "30 marts", "14.00", "GreenLand", "12", "good  clothes");
        Trip t2 = new Trip(2L,"Spain", "juli","14.00","Madrid","14","summer clothes");
        Trip t3 = new Trip(3L,"Italy", "july","14.00","Rome","14","summer clothes");
        User u1 = new User("Nicole","Nicole");
        User u2 = new User("Bo", "Bo");
        Guide g1 = new Guide("Henrik", "Male");
        Guide g2 = new Guide("Malene", "Female");
        Guide g3 = new Guide("James", "Male");

        em.getTransaction().begin();
        em.persist(t1);
        em.persist(t2);
        em.persist(t3);
        em.persist(u1);
        em.persist(u2);
        em.persist(g1);
        em.persist(g2);
        em.persist(g3);
        em.getTransaction().commit();




        //mf.submitMember(new MemberDTO(new Member("Alice", "Alice@gmail.com")));
/*
        FitnessCenter f1 = new FitnessCenter("Fun Fit","New Hazel", "309");
        FitnessCenter f2 = new FitnessCenter("Muscle Up", "Summerland", "199");
        Member m1 = new Member("Alice", "alice@inwonderland.org");
        Member m2 = new Member("Frederik", "frederik@cool.dk");
        Member m3 = new Member("Bob", "Bob@gmail.com");
        Member m4 = new Member("Sam", "sam@smith.com");
        Member m5 = new Member("Julle", "Julle@Jullemanden.nis");


        f1.addMember(m1);
        f1.addMember(m2);
        f1.addMember(m3);
        f2.addMember(m4);
        f2.addMember(m5);

        em.getTransaction().begin();
        em.persist(f1);
        em.persist(f2);
        em.getTransaction().commit();
*/
    }

    public static void main(String[] args) {
        populate();
    }
}
