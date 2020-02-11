package com.cdac.rxjava.Adapter;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.cdac.rxjava.Model.Post;

import java.util.List;


import com.cdac.rxjava.R;



public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
Context context;
    List<Post> postList;



    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.postList = posts;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_layout,parent,false);
        return new PostViewHolder(view);

    }



    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.txt_author.setText(String.valueOf(postList.get(position).userId));
        holder.txt_title.setText(String.valueOf(postList.get(position).title));
        holder.txt_content.setText(new StringBuilder(postList.get(position).body.substring(0,20)).append("...").toString());

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }
}
