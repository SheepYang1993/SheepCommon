package com.sheepyang1993.sheepcommon.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;

import com.blankj.utilcode.util.ImageUtils;
import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;
import com.sheepyang1993.sheepcommon.R;

import java.io.File;

import static android.graphics.drawable.Icon.TYPE_BITMAP;

/**
 * @author SheepYang
 * @Email 332594623@qq.com
 * @date 2019/6/8
 */
public class PhotoViewActivity extends BaseActivity {
    public static final int TYPE_BITMAP = 1;
    public static final int TYPE_URL = 2;
    private static final String EXTRA_TYPE = "EXTRA_TYPE";
    private static final String EXTRA_URL = "EXTRA_URL";
    private static final String EXTRA_BITMAP_PATH = "EXTRA_BITMAP_PATH";
    private PhotoView photoView;
    private int mType;
    private String mUrl;
    private Bitmap mBitmap;
    private String mBitmapPath;

    @Override
    public int getLayoutId() {
        return R.layout.activity_photo_view;
    }

    @Override
    protected void initView() {
        photoView = findViewById(R.id.photoView);
    }

    @Override
    protected void initData() {
        mType = getIntent().getIntExtra(EXTRA_TYPE, 0);
        switch (mType) {
            case TYPE_BITMAP:
                mBitmapPath = getIntent().getStringExtra(EXTRA_BITMAP_PATH);
                mBitmap = ImageUtils.getBitmap(new File(mBitmapPath));
                photoView.setImageBitmap(mBitmap);
                break;
            case TYPE_URL:
                mUrl = getIntent().getStringExtra(EXTRA_URL);
                Glide.with(photoView)
                        .load(mUrl)
                        .into(photoView);
                break;
            default:
                break;
        }
    }

    public static void startSelf(Context context, String bitmapPath, Bitmap bitmap) {
        Intent intent = new Intent(context, PhotoViewActivity.class);
        intent.putExtra(EXTRA_TYPE, TYPE_BITMAP);
        intent.putExtra(EXTRA_BITMAP_PATH, bitmapPath);
        context.startActivity(intent);
    }

    public static void startSelf(Context context, String url) {
        Intent intent = new Intent(context, PhotoViewActivity.class);
        intent.putExtra(EXTRA_TYPE, TYPE_URL);
        intent.putExtra(EXTRA_URL, url);
        context.startActivity(intent);
    }
}
