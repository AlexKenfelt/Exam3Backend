package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.FitnessCenter.FitnessCenterDTO;
import dtos.FitnessCenter.FitnessCentersDTO;
import facades.FitnessCenterFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("fitness")
public class FitnessResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final FitnessCenterFacade FACADE = FitnessCenterFacade.getFitnessCenterFacade(EMF);
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();


//fitness
    @Context
    SecurityContext securityContext;


    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getFitnessById(@PathParam("id") int id) {
        FitnessCenterDTO fitnessCenterDTO = FACADE.getById(id);
        return gson.toJson(fitnessCenterDTO);
    }

    @Path("/all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllFitness() {
        FitnessCentersDTO fitnessCentersDTO = FACADE.getAll();
        return gson.toJson(fitnessCentersDTO);
    }


}
