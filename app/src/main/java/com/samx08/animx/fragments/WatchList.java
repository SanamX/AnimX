package com.samx08.animx.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samx08.animx.R;
import com.samx08.animx.ongoing_recycler.HelperOngoing;
import com.samx08.animx.ongoing_recycler.OnGoingAdapter;
import com.samx08.animx.recyclerview_watch.WatchAdapter;
import com.samx08.animx.recyclerview_watch.WatchHelper;

import java.util.ArrayList;

public class WatchList extends Fragment {

    View view;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    public WatchList() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_watch_list, container, false);
        recyclerView = view.findViewById(R.id.plantorecy);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

        ArrayList<WatchHelper> location_wa = new ArrayList<>();
        location_wa.add(new WatchHelper(R.drawable.ic_launcher_background,"Sample2"));
        location_wa.add(new WatchHelper(R.drawable.ic_launcher_background,"Sample3"));
        location_wa.add(new WatchHelper(R.drawable.sanamxfirst,"Sample4"));
        location_wa.add(new WatchHelper(R.drawable.sanamxfirst,"Sample5"));
        location_wa.add(new WatchHelper(R.drawable.sanamxfirst,"Sample6"));
        location_wa.add(new WatchHelper(R.drawable.sanamxfirst,"Sample7"));

        adapter = new WatchAdapter(location_wa);
        recyclerView.setAdapter(adapter);
        return view;
    }
}