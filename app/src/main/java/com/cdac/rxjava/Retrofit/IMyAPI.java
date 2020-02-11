package com.cdac.rxjava.Retrofit;

import com.cdac.rxjava.Model.Post;

import java.util.List;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by cdac on 4/18/2019.
 */

public interface IMyAPI {

    @GET("posts")
    Observable<List<Post>> getPost();

}
