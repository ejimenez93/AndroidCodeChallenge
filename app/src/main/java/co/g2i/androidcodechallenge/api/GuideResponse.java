package co.g2i.androidcodechallenge.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import co.g2i.androidcodechallenge.model.Guide;

public class GuideResponse {
    @SerializedName("data")
    @Expose
    ArrayList<Guide> data;

    public ArrayList<Guide> getData() {
        return data;
    }

    public void setData(ArrayList<Guide> data) {
        this.data = data;
    }
}
