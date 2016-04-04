package com.neil.tumblrpic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;

import com.neil.tumblrpic.R;
import com.neil.tumblrpic.util.ImageLoader;


/**
 * Created by Neil on 2016/3/22.
 */
public class TumblrLargeImgActivity extends AppCompatActivity {
    private ImageView ivPhoto;
    private String strImg = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tumblr_img_large);
        ImageView ivPhoto = (ImageView) findViewById(R.id.iv_photo);
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (getIntent() != null) {
            strImg = getIntent().getStringExtra("IMG_URL");
            if (strImg != null) {
                ImageLoader.loadImage(ivPhoto, strImg);
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.home) {//back key
            Intent intent = NavUtils.getParentActivityIntent(this);
            if (intent != null) {
                if (NavUtils.shouldUpRecreateTask(this, intent)) {
                    TaskStackBuilder.create(this)
                            .addNextIntentWithParentStack(intent)
                            .startActivities();
                } else {
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    NavUtils.navigateUpTo(this, intent);
                }
            } else {
                Log.e("TUMBLR_IMG", "intent is null");
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
