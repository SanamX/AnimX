package com.samx08.animx.recyclerview_watch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.samx08.animx.R;

import java.util.ArrayList;

public class WatchAdapter extends RecyclerView.Adapter<WatchAdapter.ViewHolderAdapter> {
    ArrayList<WatchHelper> location_wa;

    public WatchAdapter( ArrayList<WatchHelper> location_wa)
    {
        this.location_wa = location_wa;
    }
    @NonNull
    @Override
    public WatchAdapter.ViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design_2,parent,false);
       ViewHolderAdapter viewHolderAdapter = new ViewHolderAdapter(view);
        return viewHolderAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull WatchAdapter.ViewHolderAdapter holder, int position)
    {
        WatchHelper watchHelper = location_wa.get(position);
        holder.imageView.setImageResource(watchHelper.getImage());
        holder.textView.setText(watchHelper.getText());
    }

    @Override
    public int getItemCount() {
        return location_wa.size();
    }

    public class ViewHolderAdapter extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolderAdapter(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview_new);
            textView=itemView.findViewById(R.id.textnew);
        }
    }
}
