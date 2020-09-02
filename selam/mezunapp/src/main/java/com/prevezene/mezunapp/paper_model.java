package com.prevezene.mezunapp;

import com.google.gson.annotations.SerializedName;

public class paper_model {
    public String getColumn2() {
        return Column2;
    }

    public void setColumn2(String column2) {
        Column2 = column2;
    }

    @SerializedName("origin_pattern")
    public String Column2;



}
