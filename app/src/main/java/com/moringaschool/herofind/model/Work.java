
package com.moringaschool.herofind.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Work {

    @SerializedName("occupation")
    @Expose
    private String occupation;
    @SerializedName("base")
    @Expose
    private String base;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Work() {
    }

    /**
     * 
     * @param occupation
     * @param base
     */
    public Work(String occupation, String base) {
        super();
        this.occupation = occupation;
        this.base = base;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

}
