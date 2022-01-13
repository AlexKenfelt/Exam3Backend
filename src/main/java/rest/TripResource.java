package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dtos.GuideDTO;
import dtos.TripsDTO;
import entities.Guide;
import entities.Trip;
import errorhandling.API_Exception;
import facades.TripFacade;
import facades.UserFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("trip")
public class TripResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final TripFacade instance = TripFacade.getUserFacade(EMF);
    private static final UserFacade FACADE = UserFacade.getUserFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    Trip trip = new Trip();
    Guide guide = new Guide();

    @Context
    private UriInfo context;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("alltrips")
    public String getAllTrips() {
        TripsDTO o = instance.getAllTrips();
        return GSON.toJson(o);
    }

    // lav post med createTrip

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("create/trip")
    public Response createTrip (String jsonString) throws API_Exception{
        String name;
        String date;
        String time;
        String location;
        String duration;
        String packingList;

        try {
            JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
            name = json.get("tripName").getAsString();
            trip.setName(name);
            date = json.get("tripDate").getAsString();
            trip.setDate(date);
            time = json.get("tripTime").getAsString();
            trip.setTime(time);
            location = json.get("tripLocation").getAsString();
            trip.setLocation(location);
            duration = json.get("tripDuration").getAsString();
            trip.setDuration(duration);
            packingList = json.get("tripPackingList").getAsString();
            trip.setPackingList(packingList);
            instance.createTrip(trip);
        } catch (Exception e) {
            throw new API_Exception("hehe fail", 400, e);
        }
        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("create/guide")
    public Response createGuide (String jsonString) throws API_Exception{
        String name;
        String gender;
        try {
            JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
            name = json.get("guideName").getAsString();
            guide.setName(name);
            gender = json.get("guideGender").getAsString();
            guide.setGender(gender);
            System.out.println(guide);
            System.out.println(name);
            System.out.println(gender);
            instance.createGuide(guide);
        } catch (Exception e) {
            throw new API_Exception("hehe fail", 400, e);
        }
        return null;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("allguides")
    public String getAllGuides() {
        GuideDTO g = instance.getAllGuides();
        return GSON.toJson(g);
    }

    //create new guide




}