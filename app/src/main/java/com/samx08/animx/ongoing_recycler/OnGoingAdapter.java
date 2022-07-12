package com.samx08.animx.ongoing_recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.samx08.animx.R;
import com.samx08.animx.recyclerview_one.HelperClassOne;
import com.samx08.animx.recyclerview_one.RecyclerAdapterOne;

import java.util.ArrayList;

public class OnGoingAdapter extends RecyclerView.Adapter<OnGoingAdapter.ViewHolderAdapter>
{
    ArrayList<HelperOngoing> location_on;

    public OnGoingAdapter( ArrayList<HelperOngoing> location)
    {
        this.location_on = location;
    }
    @NonNull
    @Override
    public OnGoingAdapter.ViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_design_one,parent,false);
        ViewHolderAdapter viewHolderAdapter = new ViewHolderAdapter(view);
        return viewHolderAdapter;

    }

    @Override
    public void onBindViewHolder(@NonNull OnGoingAdapter.ViewHolderAdapter holder, int position)
    {
        HelperOngoing helperOngoing = location_on.get(position);
        holder.imageView.setImageResource(helperOngoing.getImage());
        holder.textView.setText(helperOngoing.getText());
    }

    @Override
    public int getItemCount() {
        return location_on.size();
    }

    public class ViewHolderAdapter extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ViewHolderAdapter(@NonNull View itemView) {

            super(itemView);
            imageView=itemView.findViewById(R.id.myimage);
            textView=itemView.findViewById(R.id.my_text);
        }
    }
}
