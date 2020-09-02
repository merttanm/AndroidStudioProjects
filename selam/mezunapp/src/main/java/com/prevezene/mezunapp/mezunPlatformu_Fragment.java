package com.prevezene.mezunapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prevezene.mezunapp.ui.gallery.GalleryViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class mezunPlatformu_Fragment extends Fragment  {
ArrayList<paper_model> papermodel;
private String BASE_URL="https://github.com/";
Retrofit retrofit;
    ViewFlipper kayır;
    private mezunPlatformuViewModel mezunPlatformuViewModel;


    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        mezunPlatformuViewModel=
                ViewModelProviders.of(this).get(mezunPlatformuViewModel.class);
        View root = inflater.inflate(R.layout.fragment_blank, container, false);



        int images[]={R.drawable.bizden1,R.drawable.bizden2,R.drawable.bizden3,R.drawable.bizden4};
        kayır= root.findViewById(R.id.dfdf);

        for (int image:images){

            flipper(image);
        }
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        loaddata();


        return  root;



    }



    public void flipper(int image){
        ImageView imageView= new ImageView(getContext());
        imageView.setBackgroundResource(image);

        kayır.addView(imageView);
        kayır.setFlipInterval(2000);
        kayır.setAutoStart(true);

        kayır.setInAnimation(getContext(),android.R.anim.slide_in_left);
        kayır.setOutAnimation(getContext(),android.R.anim.slide_out_right);


    }


/*
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //retrofit ve json
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        loaddata();
    }
*/
/*
    public void loadJSON() {




            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson)).build();

             paperAPI  paperAPI = retrofit.create(com.prevezene.mezunapp.paperAPI.class);
             Call<List<paper_model>> call= paperAPI.getData();
            final ProgressDialog progressDialog = new ProgressDialog(getActivity());
            progressDialog.show();
        call.enqueue(new Callback<List<paper_model>>() {
                @Override
                public void onResponse(Call<List<paper_model>> call, Response<List<paper_model>> response) {
                    if (response.isSuccessful()){
                        List<paper_model> responslist=response.body();
                        papermodel= new ArrayList<>(responslist);


                    }
                }

            @Override
            public void onFailure(Call<List<paper_model>> call, Throwable t) {

            }


            });
        }


*/












    private void loaddata (){

        paperAPI  paperAPI =retrofit.create(com.prevezene.mezunapp.paperAPI.class);
        Call<List<paper_model>> call= paperAPI.getData();
        call.enqueue(new Callback<List<paper_model>>() {
            @Override
            public void onResponse(Call<List<paper_model>> call, Response<List<paper_model>> response) {
                if (response.isSuccessful()){
                    List<paper_model> responslist=response.body();
                    papermodel= new ArrayList<>(responslist);

                    for (paper_model paper_model : papermodel){

                        System.out.println(paper_model.Column2);
                    }

                }
            }

            @Override
            public void onFailure(Call<List<paper_model>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}