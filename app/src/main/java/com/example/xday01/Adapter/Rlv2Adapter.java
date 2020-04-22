package com.example.xday01.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.xday01.Bean.ProjectBean;
import com.example.xday01.R;

import java.util.ArrayList;

/**
 * Created by 文龙 on 2020/4/20.
 */

public class Rlv2Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<ProjectBean.ListBean> list;

    public Rlv2Adapter(Context context, ArrayList<ProjectBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_rlv, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.mTvTitle.setText(list.get(position).getTheme());
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(context).load(list.get(position).getImage_url()).apply(requestOptions).into(viewHolder.mTvRlv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        View view;
        TextView mTvTitle;
        ImageView mTvRlv;

        ViewHolder(View view) {
            super(view);
            this.view = view;
            this.mTvTitle = (TextView) view.findViewById(R.id.tv_title);
            this.mTvRlv = (ImageView) view.findViewById(R.id.tv_rlv);
        }
    }
}
