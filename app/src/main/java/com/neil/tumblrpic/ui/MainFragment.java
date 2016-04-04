package com.neil.tumblrpic.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.neil.tumblrpic.R;
import com.neil.tumblrpic.adapter.AdvTumblrImgAdapter;
import com.neil.tumblrpic.bean.MainImgBean;
import com.neil.tumblrpic.util.SearchImgs;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Neil on 2016/4/4.
 */
public class MainFragment extends Fragment implements GridView.OnScrollListener {
    @Bind(R.id.gv_imgs_adv)
    GridView gvImgsAdv;
    @Bind(R.id.btn_loadImg)
    Button btnLoadImg;

    private Context mContext;
    private List<MainImgBean> mDatas = new ArrayList<>();

    private String keyWord;
    private AdvTumblrImgAdapter imgAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adv_tumblr, container, false);
        ButterKnife.bind(this, view);
        btnLoadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyWord = "%E7%BE%8E%E5%A5%B3";
                imgAdapter = new AdvTumblrImgAdapter(mDatas, mContext);
                gvImgsAdv.setAdapter(imgAdapter);
                SearchImgs.searchImgs(keyWord, mContext, imgAdapter);
            }
        });
        gvImgsAdv.setOnScrollListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mContext = getActivity();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    private int visibleLastItemIdx = -1;
    private int pageId = 1;

    /**
     * 实现滑动的两个方法
     *
     * @param view
     * @param scrollState
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //如果暂停拖动，且最后显示的下标等于数据集数目-1
        int mDataSize = mDatas.size();
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE &&
                visibleLastItemIdx == mDataSize - 1) {
            //当前所有页中数据已显示完毕，请求加载下一页
            SearchImgs.searchOnImgs(keyWord, mContext, imgAdapter);
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        //当前可视窗体下，最后一条数据集的下标
        visibleLastItemIdx = firstVisibleItem + visibleItemCount - 1;
//
//        Log.e("============ ", "========================");
//        Log.e("firstVisibleItem = ", firstVisibleItem + "");
//        Log.e("visibleItemCount = ", visibleItemCount + "");
//        Log.e("totalItemCount = ", totalItemCount + "");
//        Log.e("============ ", "========================");

        visibleLastItemIdx = firstVisibleItem + visibleItemCount - 1;
        int datasize = mDatas.size();
        // 如果所有的记录选项等于数据集的条数，则移除列表底部视图
        if (totalItemCount == datasize + 1) {
            //list_View.removeFooterView(loadMoreView);
            if (mContext != null)
                Toast.makeText(mContext, "数据全部加载完!", Toast.LENGTH_SHORT).show();
        }
    }
}
