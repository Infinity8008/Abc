package com.cdac.rxjava.Adapter;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cdac.rxjava.R;




public class PostViewHolder extends RecyclerView.ViewHolder {
    TextView txt_title,txt_content,txt_author;
    public PostViewHolder(View itemView) {
        super(itemView);
        txt_title=(TextView)itemView.findViewById(R.id.txt_title);
        txt_content=(TextView)itemView.findViewById(R.id.txt_content);
        txt_author=(TextView)itemView.findViewById(R.id.txt_author);
    }


}
