package com.yjs.ganhuo.fragment.picture;

import com.yjs.ganhuo.adapter.PictureAdapter;
import com.yjs.ganhuo.base.IPresenter;
import com.yjs.ganhuo.bean.GankDailyEntity;
import com.yjs.ganhuo.fragment.baserecycleFragment.BasePullToRefreshFragment;

/**
 * Created by yangjingsong on 16/6/27.
 */
public class PictureFragment extends BasePullToRefreshFragment<GankDailyEntity,PictureAdapter> {
    @Override
    protected PictureAdapter getAdapter() {
        return null;
    }

    @Override
    protected void refreshDataWithPresenter() {

    }

    @Override
    protected void loadDataWithPresenter() {

    }

    @Override
    protected IPresenter getmPresent() {
        return null;
    }
}
