package com.example.xday01;

import com.example.xday01.Bean.ProjectBean;

import java.util.List;

/**
 * Created by 文龙 on 2020/4/20.
 */

public interface NetCallBack {
    void Success(List<ProjectBean.ListBean> list);
    void onFail(String str);
}
