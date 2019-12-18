package com.roniwahyu.movietvdb.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roniwahyu.movietvdb.Adapter.ListViewTvShowAdapter;
import com.roniwahyu.movietvdb.R;
import com.roniwahyu.movietvdb.TVSeries;
import com.roniwahyu.movietvdb.TVSeriesData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowFragment extends Fragment {
    private RecyclerView rvTvShow;
    private ArrayList<TVSeries> list = new ArrayList<>();


    public TVShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tvshow,container,false);
        rvTvShow = view.findViewById(R.id.rv_tvShow);
        rvTvShow.setHasFixedSize(true);

        list.addAll(TVSeriesData.getListData());
        showRecyclerTvShow();

        return view;
    }

    private void showRecyclerTvShow(){
        rvTvShow.setLayoutManager(new LinearLayoutManager(this.getContext()));
        ListViewTvShowAdapter listViewTvShowAdapter = new ListViewTvShowAdapter(this.getContext());
        listViewTvShowAdapter.setListTvSeries(list);
        rvTvShow.setAdapter(listViewTvShowAdapter);
    }
}
