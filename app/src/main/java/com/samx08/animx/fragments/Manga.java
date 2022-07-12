package com.samx08.animx.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.samx08.animx.R;
import com.samx08.animx.ongoing_recycler.HelperOngoing;
import com.samx08.animx.ongoing_recycler.OnGoingAdapter;
import com.samx08.animx.upcoming_recycler.HelperUpcoming;
import com.samx08.animx.upcoming_recycler.UpcomingAdapter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Manga extends Fragment {

   // StorageReference storageReference;

   // ImageView imageView;
    View view;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView2;
    RecyclerView.Adapter adapter2;
    public Manga() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_manga, container, false);

        recyclerView = view.findViewById(R.id.ongoingrecy);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        ArrayList<HelperOngoing> location_on = new ArrayList<>();
        location_on.add(new HelperOngoing(R.drawable.sanamxfirst,"Sample2"));
        location_on.add(new HelperOngoing(R.drawable.sanamxfirst,"Sample3"));
        location_on.add(new HelperOngoing(R.drawable.sanamxfirst,"Sample4"));
        location_on.add(new HelperOngoing(R.drawable.sanamxfirst,"Sample5"));
        location_on.add(new HelperOngoing(R.drawable.sanamxfirst,"Sample6"));
        location_on.add(new HelperOngoing(R.drawable.sanamxfirst,"Sample7"));

        adapter = new OnGoingAdapter(location_on);
        recyclerView.setAdapter(adapter);

        recyclerView2 = view.findViewById(R.id.upcomingrecy);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        ArrayList<HelperUpcoming> location_up = new ArrayList<>();
        location_up.add(new HelperUpcoming(R.drawable.sanamxfirst,"Sample2"));
        location_up.add(new HelperUpcoming(R.drawable.sanamxfirst,"Sample3"));
        location_up.add(new HelperUpcoming(R.drawable.sanamxfirst,"Sample4"));
        location_up.add(new HelperUpcoming(R.drawable.sanamxfirst,"Sample5"));
        location_up.add(new HelperUpcoming(R.drawable.sanamxfirst,"Sample6"));
        location_up.add(new HelperUpcoming(R.drawable.sanamxfirst,"Sample7"));

        adapter2 = new UpcomingAdapter(location_up);
        recyclerView2.setAdapter(adapter2);

        /*storageReference = FirebaseStorage.getInstance().getReference().child("image/IMG-20201011-WA0001.jpg");
        try {

            final File localFile =  File.createTempFile("IMG-20201011-WA0001","jpg");
            storageReference.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {

                    Toast.makeText(getContext(),"SuccessFul",Toast.LENGTH_LONG).show();
                    Bitmap bitmap = BitmapFactory.decodeFile(localFile.getAbsolutePath());
                    (imageView = view.findViewById(R.id.ongoingmanga)).setImageBitmap(bitmap);

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getContext(),"Try Agin Later....",Toast.LENGTH_LONG).show();
                }
            });

        }

        catch (IOException e) {
            e.printStackTrace();
        }*/
        return view;
    }
}