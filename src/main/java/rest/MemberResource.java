package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.MemberDTO;
import facades.MemberFacade;
import utils.EMF_Creator;

import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.websocket.server.PathParam;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

public class MemberResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final MemberFacade facade = MemberFacade.getMemberFacade(EMF);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Context
    SecurityContext securityContext;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getById(@PathParam("id") int id) {
        return gson.toJson(facade.getById(id));
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    public String getAll() {
        return gson.toJson(facade.getAll());
    }

    @Path("/{id}")
    @PUT
    public String editMember(@PathParam("id") int id, String member) {
        MemberDTO m = gson.fromJson(member, MemberDTO.class);
        m.setId(id);
        MemberDTO mEdited = facade.editMember(m);
        return gson.toJson(mEdited);
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteMember(@PathParam("id") int id) {
        MemberDTO deleteMember = facade.deleteMember(id);
        return gson.toJson(deleteMember);
    }

}
