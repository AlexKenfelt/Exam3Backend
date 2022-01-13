package dtos;

import entities.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripsDTO {

    //Variables

    private List<TripDTO> getAllTrips = new ArrayList<>();

    //Constructor
    public TripsDTO(List<Trip> tripList){
        tripList.forEach((tl) ->{
            getAllTrips.add(new TripDTO(tl));
        });
    }

    public List<TripDTO> getGetAllTrips() {
        return getAllTrips;
    }


    @Override
    public String toString() {
        return "TripsDTO{" +
                "getAllTrips=" + getAllTrips +
                '}';
    }
}
