package com.example.xday01.NetPresenter;

import com.example.xday01.Bean.ProjectBean;
import com.example.xday01.NetCallBack;
import com.example.xday01.NetModel.NetModel;
import com.example.xday01.NetView.NetView;

import java.util.List;

import javax.security.auth.callback.Callback;

/**
 * Created by 文龙 on 2020/4/20.
 */

public class NetPresenter implements NetCallBack {
    private NetView netView;
    private NetModel netModel;

    public NetPresenter(NetView netView) {
        this.netView = netView;
        this.netModel = new NetModel();
    }

    @Override
    public void Success(List<ProjectBean.ListBean> list) {
        netView.getData(list);
    }

    @Override
    public void onFail(String str) {
        netView.showToast(str);
    }

    public void getData() {
        netModel.getData(this);
    }
}
