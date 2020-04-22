package com.example.xday01.Fragment;


import android.annotation.TargetApi;
import android.app.Presentation;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.xday01.Adapter.Rlv2Adapter;
import com.example.xday01.Adapter.RlvAdapter;
import com.example.xday01.Bean.ProjectBean;
import com.example.xday01.NetPresenter.NetPresenter;
import com.example.xday01.NetView.NetView;
import com.example.xday01.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment implements NetView {

    private View view;
    private RecyclerView mRlv2;
    private ArrayList<ProjectBean.ListBean> list;
    private RlvAdapter rlvAdapter;
    private Rlv2Adapter rlvAdapter1;

    public TwoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_two, container, false);
        initView(inflate);
        return inflate;

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden == true){
            NetPresenter netPresenter = new NetPresenter(this);
            netPresenter.getData();
        }
    }

    private void initView(View inflate) {
        mRlv2 = (RecyclerView) inflate.findViewById(R.id.rlv2);

        mRlv2.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRlv2.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));

        list = new ArrayList<>();
        rlvAdapter1 = new Rlv2Adapter(getActivity(), list);

        mRlv2.setAdapter(rlvAdapter1);
    }

    @Override
    public void getData(List<ProjectBean.ListBean> list) {
        this.list.addAll(list);
        rlvAdapter1.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }
}
