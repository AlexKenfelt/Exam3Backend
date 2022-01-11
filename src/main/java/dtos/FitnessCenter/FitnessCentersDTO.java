package dtos.FitnessCenter;

import entities.FitnessCenter;

import java.util.ArrayList;
import java.util.List;

public class FitnessCentersDTO {

    List<FitnessCenterDTO> all = new ArrayList();

    public FitnessCentersDTO(List<FitnessCenter> fitnessCenterEntities) {
        fitnessCenterEntities.forEach((p) -> {
            all.add(new FitnessCenterDTO(p));
        });
    }

    public List<FitnessCenterDTO> getAll() {
        return all;
    }

    @Override
    public String toString() {
        return "FitnessCenterDTO{" +
                "all=" + all +
                '}';
    }






}
