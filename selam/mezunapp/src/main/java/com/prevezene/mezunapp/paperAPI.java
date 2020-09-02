package com.prevezene.mezunapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface paperAPI {
@GET("merttanm/AndroidStudioProjects/blob/master/jsonDataset")
    Call<List<paper_model>> getData();

}
