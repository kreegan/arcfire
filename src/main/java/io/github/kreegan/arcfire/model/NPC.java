package io.github.kreegan.arcfire.model;

import io.github.kreegan.arcfire.generator.Generatable;

import java.util.Map;

/**
 * Object representing an NPC
 */
public class NPC implements Generatable<NPC> {
    private String name;
    private String race;
    private Gender gender;
    private String description;
    private String profession;

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void generateOverride(Map<String, Object> parameters) {
        generateInternal(parameters, this);
    }
}
