package co.g2i.androidcodechallenge.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.g2i.androidcodechallenge.R;
import co.g2i.androidcodechallenge.model.Guide;

import static android.view.View.GONE;

public class GuideViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.guideImage)
    ImageView guideImage;

    @BindView(R.id.guideName)
    TextView guideName;

    @BindView(R.id.guideDates)
    TextView guideDates;

    @BindView(R.id.guideVenue)
    TextView guideVenue;

    private Context mContext;

    public GuideViewHolder(View itemView, Context context) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = context;
    }

    public void bindGuide(Guide guide) {
        Picasso.with(mContext).load(guide.getIcon()).into(guideImage);
        guideName.setText(guide.getName());
        guideDates.setText(guide.getStartDate() + " - " + guide.getEndDate());

        if (guide.getVenue().getCity() != null && guide.getVenue().getState() != null) {
            guideVenue.setText(guide.getVenue().getCity() + ", " + guide.getVenue().getState());
        }
        else {
            guideVenue.setVisibility(GONE);
        }

    }
}