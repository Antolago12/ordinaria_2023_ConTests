package org.vaadin.example;

import java.util.List;

public class Starship {
    private String name;
    private String model;
    private String cost_in_credits;
    private String crew;
    private String cargo_capacity;
    private String consumables;
    private String hyperdrive_rating;
    private String starship_class;
    private List<String> pilots;
    private List<String> films;

    // Constructor vacío
    public Starship() {
    }

    // Getters y Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getCost_in_credits() {
        return cost_in_credits;
    }
    public void setCost_in_credits(String cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
    }

    public String getCrew() {
        return crew;
    }
    public void setCrew(String crew) {
        this.crew = crew;
    }

    public String getCargo_capacity() {
        return cargo_capacity;
    }
    public void setCargo_capacity(String cargo_capacity) {
        this.cargo_capacity = cargo_capacity;
    }

    public String getConsumables() {
        return consumables;
    }
    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getHyperdrive_rating() {
        return hyperdrive_rating;
    }
    public void setHyperdrive_rating(String hyperdrive_rating) {
        this.hyperdrive_rating = hyperdrive_rating;
    }

    public String getStarship_class() {
        return starship_class;
    }
    public void setStarship_class(String starship_class) {
        this.starship_class = starship_class;
    }

    public List<String> getPilots() {
        return pilots;
    }
    public void setPilots(List<String> pilots) {
        this.pilots = pilots;
    }

    public List<String> getFilms() {
        return films;
    }
    public void setFilms(List<String> films) {
        this.films = films;
    }
}
