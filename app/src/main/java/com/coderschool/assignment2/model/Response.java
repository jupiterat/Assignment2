package com.coderschool.assignment2.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by duongthoai on 10/23/16.
 */

public class Response {
    @SerializedName("status")
    String status;
    @SerializedName("copyright")
    String copyright;
    @SerializedName("docs")
    List<Article> articles;

}
