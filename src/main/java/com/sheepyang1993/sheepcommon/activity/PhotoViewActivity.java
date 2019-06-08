package com.sheepyang1993.sheepcommon.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;

import com.github.chrisbanes.photoview.PhotoView;
import com.sheepyang1993.sheepcommon.R;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/6/8
 */
public class PhotoViewActivity extends BaseActivity {
    private static final String EXTRA_BITMAP = "EXTRA_BITMAP";
    private PhotoView photoView;
    private Bitmap mBitmap;

    @Override
    public int getLayoutId() {
        return R.layout.activity_photo_view;
    }

    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected void initView() {
        photoView = findViewById(R.id.photoView);
    }

    @Override
    protected void initData() {
        mBitmap = getIntent().getParcelableExtra(EXTRA_BITMAP);
        photoView.setImageBitmap(mBitmap);
    }

    public static void startSelf(Context context, Bitmap bitmap) {
        Intent intent = new Intent(context, PhotoViewActivity.class);
        intent.putExtra(EXTRA_BITMAP, bitmap);
        context.startActivity(intent);
    }
}
