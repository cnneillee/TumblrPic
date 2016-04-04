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
import com.neil.tumblrpic.util.ImageLoader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Created by Neil on 2016/3/22.
 */
public class AdvTumblrImgAdapter extends BaseAdapter {
    //使用缓存机制
    /**
     * 记录所有正在下载或等待下载的任务。
     */
    private Set<BitmapWorkerTask> taskCollection;
    /**
     * 图片缓存技术的核心类，用于缓存所有下载好的图片，在程序内存达到设定值时会将最少最近使用的图片移除掉。
     */
    private LruCache<String, Bitmap> mMemoryCache;

    /**
     * 第一张可见图片的下标
     */
    private int mFirstVisibleItem;

    /**
     * 一屏有多少张图片可见
     */
    private int mVisibleItemCount;
    /**
     * 记录是否刚打开程序，用于解决进入程序不滚动屏幕，不会下载图片的问题。
     */
    private boolean isFirstEnter = true;


    private List<MainImgBean> mDatas;
    private Context mContext;

    public AdvTumblrImgAdapter(List<MainImgBean> datas, Context context) {
        mDatas = datas;
        mContext = context;
        taskCollection = new HashSet<BitmapWorkerTask>();

        // 获取应用程序最大可用内存
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 8;
        // 设置图片缓存大小为程序最大可用内存的1/8
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getByteCount();
            }
        };
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
        // 给ImageView设置一个Tag，保证异步加载图片时不会乱序
        vh.ivPhoto.setTag(mDatas.get(position).getSrc());
        setImageView(vh.ivPhoto, mDatas.get(position).getSrc());
        return convertView;
    }

    private void setImageView(ImageView ivPhoto, String src) {
        Bitmap bitmap = mMemoryCache.get(src);
        if (bitmap != null) {
            ivPhoto.setImageBitmap(bitmap);
        } else {
            ivPhoto.setImageBitmap(BitmapFactory.
                    decodeResource(mContext.getResources(), R.drawable.ic_v2ex));
            // TODO: 2016/4/4  待处理
            ImageLoader.loadImage(ivPhoto, src, mMemoryCache);
        }
    }

    /**
     * 将一张图片存储到LruCache中。
     *
     * @param key    LruCache的键，这里传入图片的URL地址。
     * @param bitmap LruCache的键，这里传入从网络上下载的Bitmap对象。
     */
    public void addBitmapToMemoryCache(String key, Bitmap bitmap) {
        if (getBitmapFromMemoryCache(key) == null) {
            mMemoryCache.put(key, bitmap);
        }
    }

    /**
     * 从LruCache中获取一张图片，如果不存在就返回null。
     *
     * @param key LruCache的键，这里传入图片的URL地址。
     * @return 对应传入键的Bitmap对象，或者null。
     */
    public Bitmap getBitmapFromMemoryCache(String key) {
        return mMemoryCache.get(key);
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
