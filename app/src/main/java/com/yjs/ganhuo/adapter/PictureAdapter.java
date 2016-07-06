package com.yjs.ganhuo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yjs.ganhuo.R;
import com.yjs.ganhuo.bean.GankDailyEntity;

/**
 * Created by yangjingsong on 16/6/27.
 */
public class PictureAdapter extends BaseRecyclerAdapter<GankDailyEntity,PictureAdapter.ViewHolder> {
    @Override
    public PictureAdapter.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_welfare_staggered,parent,false);
        return new PictureAdapter.ViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(PictureAdapter.ViewHolder holder, int position) {

    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
