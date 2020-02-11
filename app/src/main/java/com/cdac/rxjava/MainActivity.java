package com.cdac.rxjava;


import android.os.Bundle;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.cdac.rxjava.Adapter.PostAdapter;
import com.cdac.rxjava.Model.Post;
import com.cdac.rxjava.Retrofit.IMyAPI;
import com.cdac.rxjava.Retrofit.RetrofitClient;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {
    IMyAPI myAPI;
    RecyclerView recycler_post;
    CompositeDisposable compositeDisposable=new CompositeDisposable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI=retrofit.create(IMyAPI.class);

        recycler_post=(RecyclerView)findViewById(R.id.recyler_post);
        recycler_post.setHasFixedSize(true);
        recycler_post.setLayoutManager(new LinearLayoutManager(this));
        fetchData();
    }

    private void fetchData() {
        compositeDisposable.add(myAPI.getPost()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer <List<Post>>(){
            @Override
                public void accept(List<Post> postList) throws Exception {

                Log.d("123","Data"+String.valueOf(postList.get(1).title));


                displayData(postList);
            }

                }));
    }

    private void displayData(List<Post> posts) {
        PostAdapter postAdapter=new PostAdapter(this,posts);
        recycler_post.setAdapter(postAdapter);
    }
}
