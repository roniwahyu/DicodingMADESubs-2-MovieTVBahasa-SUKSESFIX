package com.roniwahyu.movietvdb.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.roniwahyu.movietvdb.R;
import com.roniwahyu.movietvdb.TVSeries;
import com.roniwahyu.movietvdb.TVSeriesDetailActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListViewTvShowAdapter extends RecyclerView.Adapter<ListViewTvShowAdapter.ListViewViewHolder> {

    private Context context;
    private ArrayList<TVSeries> listTvSeries;

    public ListViewTvShowAdapter(Context context) {
        this.context = context;
    }
    public ArrayList<TVSeries> getListTvSeries() {
        return listTvSeries;
    }

    public void setListTvSeries(ArrayList<TVSeries> listTvSeries) {
        this.listTvSeries = listTvSeries;
    }


    @NonNull
    @Override
    public ListViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_tv_show, viewGroup, false);
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlistviewmovies, viewGroup, false);
        return new ListViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewViewHolder listViewViewHolder, int position) {
        TVSeries tvSeries = getListTvSeries().get(position);
        Glide.with(context)
                .load(tvSeries.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(listViewViewHolder.imgPhoto);

        listViewViewHolder.tvTitle.setText(tvSeries.getTitle());
        listViewViewHolder.tvDateReleased.setText(tvSeries.getDate_released());
        listViewViewHolder.tvUserScore.setText(tvSeries.getUser_score());
        listViewViewHolder.tvRuntime.setText(tvSeries.getRuntime());

    }

    @Override
    public int getItemCount() {
        return getListTvSeries().size();
    }

    class ListViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPhoto;
        TextView tvTitle, tvRuntime, tvDateReleased, tvUserScore;

        ListViewViewHolder(@NonNull final View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvTitle = itemView.findViewById(R.id.tv_item_title);
            tvDateReleased = itemView.findViewById(R.id.tv_item_dateReleased);
            tvUserScore = itemView.findViewById(R.id.tv_item_userScore);
            tvRuntime = itemView.findViewById(R.id.tv_item_runtime);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            TVSeries tvSeries = getListTvSeries().get(position);

            tvSeries.setTitle(tvSeries.getTitle());
            tvSeries.setOverview(tvSeries.getOverview());

            Intent moveWithObjectIntent = new Intent(itemView.getContext(), TVSeriesDetailActivity.class);
            moveWithObjectIntent.putExtra(TVSeriesDetailActivity.EXTRA_TV_SHOW, tvSeries);
            context.startActivity(moveWithObjectIntent);
        }
    }
}
