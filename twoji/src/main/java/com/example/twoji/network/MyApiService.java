package com.example.twoji.network;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * author:${张四佟}
 * date:2019/3/7 18:57
 * description
 */
public interface MyApiService {
    @GET
    Observable<ResponseBody> get(@Url String myPath, @QueryMap Map<String,String> map);
    @GET
    Observable<ResponseBody> getAll(@Url String myPath);
}
