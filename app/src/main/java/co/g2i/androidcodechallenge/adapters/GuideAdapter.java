package co.g2i.androidcodechallenge.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import co.g2i.androidcodechallenge.R;
import co.g2i.androidcodechallenge.model.Guide;

public class GuideAdapter extends RecyclerView.Adapter<GuideViewHolder>{

    private List<Guide> mGuides;
    private Context mContext;

    public GuideAdapter(List<Guide> guides, Context context) {
        mGuides = guides;
        mContext = context;
    }

    @Override
    public void onBindViewHolder(GuideViewHolder holder, int position) {
        holder.bindGuide(mGuides.get(position));
    }

    @Override
    public int getItemCount() {
        return (mGuides != null ? mGuides.size() : 0);
    }

    public void loadNewData(ArrayList<Guide> guides) {
        mGuides = guides;
        notifyDataSetChanged();
    }

    @Override
    public GuideViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guide_item, parent, false);
        return new GuideViewHolder(view, mContext);
    }

}
