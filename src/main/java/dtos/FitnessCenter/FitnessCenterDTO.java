package dtos.FitnessCenter;

import entities.FitnessCenter;

public class FitnessCenterDTO {

    private Integer id;
    private String name;
    private String city;
    private String pricePrMonth;

    public FitnessCenterDTO(Integer id, String name, String city, String pricePrMonth) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.pricePrMonth = pricePrMonth;
    }

    public FitnessCenterDTO(FitnessCenter fitnessCenter) {
        this.id = fitnessCenter.getId();
        this.name = fitnessCenter.getName();
        this.city = fitnessCenter.getCity();
        this.pricePrMonth = fitnessCenter.getPricePrMonth();
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPricePrMonth() {
        return pricePrMonth;
    }

    public void setPricePrMonth(String pricePrMonth) {
        this.pricePrMonth = pricePrMonth;
    }
}
