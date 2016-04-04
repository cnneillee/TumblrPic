package com.neil.tumblrpic.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.neil.tumblrpic.Constant;
import com.neil.tumblrpic.R;
import com.neil.tumblrpic.bean.MainImgBean;
import com.neil.tumblrpic.ui.TumblrLargeImgActivity;
import com.neil.tumblrpic.util.ImageLoaderFactory;
import com.neil.tumblrpic.util.ImageLoaderWrapper;
import com.neil.tumblrpic.util.UniversalAndroidImageLoader;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.List;


/**
 * Created by Neil on 2016/3/22.
 */
public class AdvTumblrImgAdapter extends BaseAdapter {
    private List<MainImgBean> mDatas;
    private Context mContext;

    public AdvTumblrImgAdapter(List<MainImgBean> datas, Context context) {
        mDatas = datas;
        mContext = context;
    }

    public List<MainImgBean> getmDatas() {
        return mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).
                    inflate(R.layout.item_gv_tumblr_img_node, parent, false);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.ivPhoto.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_v2ex));
        vh.ivPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TumblrLargeImgActivity.class);
                intent.putExtra(Constant.PASS_ON_IMG_URL, mDatas.get(position).getSrc());
                mContext.startActivity(intent);
            }
        });
        vh.tvDescription.setText(mDatas.get(position).getDesc());

//        final ViewHolder finalVh = vh;
//        ImageLoader.getInstance().loadImage(mDatas.get(position).getSrc(), new SimpleImageLoadingListener() {
//            @Override
//            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
//                super.onLoadingComplete(imageUri, view, loadedImage);
//                finalVh.ivPhoto.setImageBitmap(loadedImage);
//            }
//        });

        UniversalAndroidImageLoader.init(mContext);

        ImageLoaderWrapper.DisplayOption displayOption = new ImageLoaderWrapper.DisplayOption();
        displayOption.loadingResId = R.mipmap.img_default;
        displayOption.loadErrorResId = R.mipmap.img_error;

        ImageLoaderFactory.getLoader().displayImage(vh.ivPhoto, mDatas.get(position).getSrc(), displayOption);
        return convertView;
    }

    class ViewHolder {
        ImageView ivPhoto;
        TextView tvDescription;

        ViewHolder(View view) {
            this.ivPhoto = (ImageView) view.findViewById(R.id.iv_photo);
            this.tvDescription = (TextView) view.findViewById(R.id.tv_description);
        }
    }
}
