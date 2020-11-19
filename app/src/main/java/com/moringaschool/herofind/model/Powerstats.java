
package com.moringaschool.herofind.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Powerstats {

    @SerializedName("intelligence")
    @Expose
    private String intelligence;
    @SerializedName("strength")
    @Expose
    private String strength;
    @SerializedName("speed")
    @Expose
    private String speed;
    @SerializedName("durability")
    @Expose
    private String durability;
    @SerializedName("power")
    @Expose
    private String power;
    @SerializedName("combat")
    @Expose
    private String combat;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Powerstats() {
    }

    /**
     * 
     * @param strength
     * @param durability
     * @param combat
     * @param power
     * @param speed
     * @param intelligence
     */
    public Powerstats(String intelligence, String strength, String speed, String durability, String power, String combat) {
        super();
        this.intelligence = intelligence;
        this.strength = strength;
        this.speed = speed;
        this.durability = durability;
        this.power = power;
        this.combat = combat;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDurability() {
        return durability;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getCombat() {
        return combat;
    }

    public void setCombat(String combat) {
        this.combat = combat;
    }

}
