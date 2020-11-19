
package com.moringaschool.herofind.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Hero {

    @SerializedName("response")
    @Expose
    private String response;
    @SerializedName("results-for")
    @Expose
    private String resultsFor;
    @SerializedName("results")
    @Expose
    private List<Result> results = new ArrayList<>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Hero() {
    }

    /**
     * 
     * @param resultsFor
     * @param response
     * @param results
     */
    public Hero(String response, String resultsFor, List<Result> results) {
        super();
        this.response = response;
        this.resultsFor = resultsFor;
        this.results = results;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResultsFor() {
        return resultsFor;
    }

    public void setResultsFor(String resultsFor) {
        this.resultsFor = resultsFor;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
