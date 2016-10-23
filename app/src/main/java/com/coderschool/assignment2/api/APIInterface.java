package com.coderschool.assignment2.api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by duongthoai on 10/15/16.
 */

public interface APIInterface {

    @GET("articlesearch.json")
    Observable<String> getArticels(@Query("q") String query,
                                   @Query("begin_date") String begin,
                                   @Query("sort") String sort,
                                   @Query("fq") String fq);
}
