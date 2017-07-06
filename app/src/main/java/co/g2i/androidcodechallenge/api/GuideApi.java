package co.g2i.androidcodechallenge.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GuideApi {

    @GET("upcomingGuides/")
    Call<GuideResponse> listGuides();
}
