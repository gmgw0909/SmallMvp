package com.leeboo.smallmvp.biz.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.widget.Toast;

import com.leeboo.smallmvp.R;
import com.leeboo.smallmvp.base.BaseActivity;
import com.leeboo.smallmvp.biz.adapter.RefreshRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {
    private SwipeRefreshLayout demo_swiperefreshlayout;
    private RecyclerView demo_recycler;
    private RefreshRecyclerAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private int lastVisibleItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        demo_swiperefreshlayout = (SwipeRefreshLayout) this.findViewById(R.id.demo_swiperefreshlayout);
        demo_recycler = (RecyclerView) this.findViewById(R.id.demo_recycler);
        //设置刷新时动画的颜色，可以设置4个
        demo_swiperefreshlayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        demo_swiperefreshlayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        demo_swiperefreshlayout.setProgressViewOffset(false, 0, (int) TypedValue
                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
                        .getDisplayMetrics()));
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        demo_recycler.setLayoutManager(linearLayoutManager);
        //添加分隔线
        demo_recycler.addItemDecoration(
                new DividerItemDecoration(HomeActivity.this, DividerItemDecoration.VERTICAL));
        demo_recycler.setAdapter(adapter = new RefreshRecyclerAdapter(this));
        demo_swiperefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<String> new_data = new ArrayList<>();
                        for (int i = 0; i < 5; i++) {
                            int index = i + 1;
                            new_data.add("new item" + index);
                        }
                        adapter.addItem(new_data);
                        demo_swiperefreshlayout.setRefreshing(false);
                        Toast.makeText(HomeActivity.this, "更新了五条数据...", Toast.LENGTH_SHORT).show();
                    }
                }, 2500);
            }
        });

        //RecyclerView滑动监听
        demo_recycler.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount()) {
                    adapter.changeMoreStatus(RefreshRecyclerAdapter.LOADING_MORE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            List<String> newDatas = new ArrayList<String>();
                            for (int i = 0; i < 5; i++) {
                                int index = i + 1;
                                newDatas.add("more item" + index);
                            }
                            adapter.addMoreItem(newDatas);
                            adapter.changeMoreStatus(RefreshRecyclerAdapter.PULL_UP_LOAD_MORE);
                        }
                    }, 2500);
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            }
        });

    }
}
