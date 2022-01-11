package facades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import entities.FitnessCenter;
import entities.Member;
import utils.EMF_Creator;

public class Populator {

    public static void populate() {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();

        MemberFacade mf = MemberFacade.getMemberFacade(emf);
        FitnessCenterFacade fcf = FitnessCenterFacade.getFitnessCenterFacade(emf);
        EntityManager em = emf.createEntityManager();

        //mf.submitMember(new MemberDTO(new Member("Alice", "Alice@gmail.com")));

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

    }

    public static void main(String[] args) {
        populate();
    }
}
