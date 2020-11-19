
package com.moringaschool.herofind.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Image {

    @SerializedName("url")
    @Expose
    private String url;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Image() {
    }

    /**
     * 
     * @param url
     */
    public Image(String url) {
        super();
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
