package com.example.xday01.Fragment;


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
public class OneFragment extends Fragment implements NetView {


    private View view;
    private RecyclerView mRlv;
    private ArrayList<ProjectBean.ListBean> list;
    private RlvAdapter rlvAdapter;

    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_one, container, false);
        initView(inflate);
        NetPresenter netPresenter = new NetPresenter(this);
        netPresenter.getData();
        return inflate;
    }

    private void initView(View inflate) {
        mRlv = (RecyclerView) inflate.findViewById(R.id.rlv);

        mRlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRlv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));

        list = new ArrayList<>();
        rlvAdapter = new RlvAdapter(getActivity(), list);
        mRlv.setAdapter(rlvAdapter);
    }

    @Override
    public void getData(List<ProjectBean.ListBean> list) {
        this.list.addAll(list);
        rlvAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }
}
