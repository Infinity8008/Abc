package com.cdac.rxjava.Model;

/**
 * Created by cdac on 4/18/2019.
 */

public class Post
{
    public int userId;
    public int id ;
    public String title ;
    public String body ;

    public Post() {

    }

    public Post(int userId, String body, String title, int id) {
        this.userId = userId;
        this.body = body;
        this.title = title;
        this.id = id;
    }


}