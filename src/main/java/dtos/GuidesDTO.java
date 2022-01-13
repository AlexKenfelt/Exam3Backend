package dtos;

import entities.Guide;
import entities.Trip;

import java.util.ArrayList;
import java.util.List;

public class GuidesDTO {

    //Variables

    private List<GuideDTO> getAllGuides = new ArrayList<>();

    //Constructor
    public GuidesDTO(List<Guide> guideList){
        guideList.forEach((gl) ->{
            getAllGuides.add(new GuideDTO(gl));
        });
    }
    public List<GuideDTO> getAllGuides() {
        return getAllGuides;
    }

    @Override
    public String toString() {
        return "GuidesDTO{" +
                "getAllGuides=" + getAllGuides +
                '}';
    }
}
