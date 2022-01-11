package facades;

import dtos.MemberDTO;
import entities.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
import java.util.List;

public class MemberFacade {


    private static EntityManagerFactory emf;
    private static MemberFacade instance;

    private MemberFacade (){

    }

    public static MemberFacade getMemberFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MemberFacade();
        }
        return instance;
    }

    public MemberDTO submitMember (MemberDTO memberDTO){
        EntityManager em = emf.createEntityManager();
        Member member = new Member(memberDTO.getName(), memberDTO.getEmail());
    try{
        em.getTransaction().begin();
        em.persist(member);
        em.getTransaction().commit();
        return new MemberDTO(member);
    }finally {
        em.close();
    }
    }

    public MemberDTO editMember(MemberDTO memberDTO){
        EntityManager em = emf.createEntityManager();
        try {
            Member member = em.find(Member.class, memberDTO.getId());

            member.setName(memberDTO.getName());
            member.setEmail(memberDTO.getEmail());

            em.getTransaction().begin();
            em.merge(member);
            em.getTransaction().commit();
            return new MemberDTO(member);
        }finally {
            em.close();
        }
    }

    public MemberDTO deleteMember(int id) throws WebApplicationException {
        EntityManager em = emf.createEntityManager();
        Member member = em.find(Member.class, id);
        if (member == null) {
            throw new WebApplicationException("There is no member matching the id");
        } else {
            try {
                em.getTransaction().begin();
                em.remove(member);
                em.getTransaction().commit();
                return new MemberDTO(member);
            } finally {
                em.close();
            }
        }
    }

        public MemberDTO getAll() {
            EntityManager em = emf.createEntityManager();
            try {
                TypedQuery<Member> query = em.createQuery("SELECT a from Member a", Member.class);
                List<Member> result = query.getResultList();
                return new MemberDTO((Member) result);
            } finally {
                em.close();
            }
        }

        public MemberDTO getById (int id){
        EntityManager em = emf.createEntityManager();
        try{
            Member member = em.find(Member.class, id);
            return new MemberDTO(member);
        } finally {
           em.close();
        }
    }

}
