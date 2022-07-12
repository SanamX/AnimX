package com.samx08.animx.recyclerview_one;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.rpc.Help;
import com.samx08.animx.AnimeDetail;
import com.samx08.animx.R;
import com.samx08.animx.model.ImageModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterOne extends RecyclerView.Adapter<RecyclerAdapterOne.ViewHolderAdapter> {

    List<HelperClassOne> loacation;
    private Context mContext;

    public RecyclerAdapterOne(Context context, List<HelperClassOne> loacation) {
        this.loacation = loacation;
        this.mContext = context;

    }


    @NonNull
    @Override
    public RecyclerAdapterOne.ViewHolderAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_design_one, parent, false);
        ViewHolderAdapter viewHolderAdapter = new ViewHolderAdapter(view);
        return viewHolderAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterOne.ViewHolderAdapter holder, int position) {

        final HelperClassOne helperClassOne = loacation.get(position);
        holder.textView.setText(helperClassOne.getText());
        holder.imageView.setImageResource(helperClassOne.getImage());

        holder.linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,AnimeDetail.class);
                intent.putExtra("anime_image",helperClassOne.getImage());
                intent.putExtra("anime_title",helperClassOne.getText());
                intent.putExtra("anime_info",helperClassOne.getInfo());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return loacation.size();
    }

    public class ViewHolderAdapter extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        LinearLayout linear;
        public ViewHolderAdapter(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.myimage);
            textView = itemView.findViewById(R.id.my_text);
            linear = itemView.findViewById(R.id.linear);

        }
    }
}
