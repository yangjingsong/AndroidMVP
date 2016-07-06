package com.yjs.ganhuo.activity.zhihudetail;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yjs.ganhuo.R;
import com.yjs.ganhuo.base.BaseActivity;
import com.yjs.ganhuo.bean.ZhihuDetail;
import com.yjs.ganhuo.fragment.zhihu.ZhihuPresenter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by yangjingsong on 16/6/17.
 */
public class ZhihuDetailActivity extends BaseActivity<ZhihuDetailPresenter> implements ZhihuDetailIView {

    @Bind(R.id.image)
    ImageView image;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.webView)
    WebView webView;
    ZhihuDetailPresenter zhihuPresenter;
    @Bind(R.id.toolbarLayout)
    CollapsingToolbarLayout toolbarLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhihu_detail;
    }

    @Override
    protected void initEventAndData() {

        zhihuPresenter = new ZhihuDetailPresenter(this,this);
        zhihuPresenter.getZhihuDetail(getIntent().getIntExtra("id", 0));



    }

    @Override
    protected ZhihuDetailPresenter getmPresent() {
        return new ZhihuDetailPresenter(this, ZhihuDetailActivity.this);
    }


    @Override
    public void setZhihuDetail(ZhihuDetail detail) {
        Glide.with(this).load(detail.getImage()).into(image);
        toolbarLayout.setTitle(detail.getTitle());

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);

        String css = "<link rel=\"stylesheet\" href=\"file:///android_asset/css/news.css\" type=\"text/css\">";
        String html = "<html><head>" + css + "</head><body>" + detail.getBody() + "</body></html>";
        html = html.replace("<div class=\"img-place-holder\">", "");
        webView.loadDataWithBaseURL("x-data://base", html, "text/html", "UTF-8", null);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showContent() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showNoData() {

    }


}
