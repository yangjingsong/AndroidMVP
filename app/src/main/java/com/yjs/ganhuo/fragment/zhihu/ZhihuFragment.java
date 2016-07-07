package com.yjs.ganhuo.fragment.zhihu;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yjs.ganhuo.R;
import com.yjs.ganhuo.adapter.ZhihuAdapter;
import com.yjs.ganhuo.base.IPresenter;
import com.yjs.ganhuo.bean.ZhihuDailyItem;
import com.yjs.ganhuo.fragment.baserecycleFragment.BasePullToRefreshFragment;
import com.yjs.ganhuo.view.LoadingView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhihuFragment extends BasePullToRefreshFragment<ZhihuDailyItem,ZhihuAdapter> {


    int pageNum = 0;

    ZhihuPresenter presenter;

    @Override
    protected IPresenter getmPresent() {
        return presenter;
    }


    @Override
    protected ZhihuAdapter getAdapter() {
        return new ZhihuAdapter();
    }

    @Override
    protected void initDatas() {

    }

    @Override
    protected void refreshDataWithPresenter() {
        presenter = new ZhihuPresenter(this,getActivity());
        pageNum = 0;
        presenter.getZhihuDailyList(0);
        adapter.setActivity(getActivity());

    }

    @Override
    protected void loadDataWithPresenter() {
        pageNum ++;
        Log.d("page",pageNum+"");
        presenter.getZhihuDailyList(pageNum);

    }

    @Override
    protected void doSomethingOnScroll(int firstVisiblePsition) {
        super.doSomethingOnScroll(firstVisiblePsition);
        Log.d("position",firstVisiblePsition+"");
        ZhihuDailyItem item= adapter.getmData().get(firstVisiblePsition);
        if(item.getPosition()==0){
            Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
            toolbar.setTitle(item.getDate());
        }
    }
}
