package com.example.xday01;

import com.example.xday01.Bean.ProjectBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 文龙 on 2020/4/20.
 */

public interface ApiService {
    String projecturl = "http://yun918.cn/";
    @GET("live/xsxcjfsj.json")
    Observable<ProjectBean> getData();
}
