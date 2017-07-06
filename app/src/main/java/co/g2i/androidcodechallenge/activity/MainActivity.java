package co.g2i.androidcodechallenge.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.g2i.androidcodechallenge.R;
import co.g2i.androidcodechallenge.adapters.GuideAdapter;
import co.g2i.androidcodechallenge.api.GuideApi;
import co.g2i.androidcodechallenge.api.GuideResponse;
import co.g2i.androidcodechallenge.api.ServiceGenerator;
import co.g2i.androidcodechallenge.model.Guide;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private GuideApi mGuideApi;

    private GuideAdapter mGuideAdapter;

    @BindView(R.id.guideRecyclerView)
    RecyclerView guideRecyclerView;

    @BindView(R.id.toolBar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mGuideApi = ServiceGenerator.createService(GuideApi.class);

        setSupportActionBar(mToolbar);

        mGuideAdapter = new GuideAdapter(new ArrayList<Guide>(), this);
        guideRecyclerView.setAdapter(mGuideAdapter);
        guideRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //guideRecyclerView.setItemAnimator(new DefaultItemAnimator());

        getUpcomingGuides();
    }

    private void getUpcomingGuides() {
        Call<GuideResponse> call = mGuideApi.listGuides();
        call.enqueue(new Callback<GuideResponse>() {
            @Override
            public void onResponse(Call<GuideResponse> call, Response<GuideResponse> response) {
                if (response.isSuccessful()) {
                    GuideResponse guideResponse = response.body();
                    final ArrayList<Guide> guides = guideResponse.getData();

                    mGuideAdapter.loadNewData(guides);

                }
            }

            @Override
            public void onFailure(Call<GuideResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

}
