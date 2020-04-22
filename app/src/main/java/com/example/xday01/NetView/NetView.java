package com.example.xday01.NetView;

import com.example.xday01.Bean.ProjectBean;

import java.util.List;

/**
 * Created by 文龙 on 2020/4/20.
 */

public interface NetView {
    void getData(List<ProjectBean.ListBean> list);
    void showToast(String str);
}
